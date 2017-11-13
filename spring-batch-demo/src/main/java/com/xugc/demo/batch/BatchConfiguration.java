package com.xugc.demo.batch;

import com.xugc.demo.entity.UmUser;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Random;

/**
 * Created by xuguocheng on 2017/9/6.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private JobCompletionNotificationListener jobCompletionNotificationListener;

    @Autowired
    private DataSource dataSource;

    @Bean
    public ItemReader<UmUser> reader() {

        MyBatisCursorItemReader<UmUser> reader = new MyBatisCursorItemReader<UmUser>();
        reader.setSqlSessionFactory(sqlSessionFactory);
        reader.setQueryId("com.xugc.demo.dao.UmUserDao.selectAllUsers");
        return reader;
    }

    @Bean
    public ItemProcessor<UmUser, UmUser> processor() {
        return new ItemProcessor<UmUser, UmUser>() {

            Random random = new Random();

            @Override
            public UmUser process(UmUser item) throws Exception {
                UmUser user = new UmUser();
                user.setId(item.getId());
                user.setName(item.getName() + random.nextInt(10));
                logger.info("Converting (" + item + ") into (" + user + ")");
                return user;
            }
        };
    }

    @Bean
    public ItemWriter<UmUser> mybatisWriter() {
        MyBatisBatchItemWriter<UmUser> writer = new MyBatisBatchItemWriter<UmUser>();
        writer.setSqlSessionFactory(sqlSessionFactory);
        writer.setStatementId("com.xugc.demo.dao.UmUserDao.updateUser");
        return writer;
    }

    @Bean
    public ItemWriter<UmUser> jdbcwriter() {

        JdbcBatchItemWriter<UmUser> writer = new JdbcBatchItemWriter<UmUser>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<UmUser>());
        writer.setSql("insert into um_user_des (name) values(:name)");
        writer.setDataSource(dataSource);
        return writer;
    }


    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("refreshUserNameJob")
                .incrementer(new RunIdIncrementer())
                .listener(jobCompletionNotificationListener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<UmUser, UmUser>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(jdbcwriter())
                .build();
    }
}
