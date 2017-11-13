package com.xugc.demo.batch;

import com.xugc.demo.dao.UmUserDao;
import com.xugc.demo.entity.UmUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xuguocheng on 2017/9/8.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Autowired
    private UmUserDao userDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            List<UmUser> results = userDao.selectAllUsers();
            List<?> list = jdbcTemplate.queryForList("select * from um_user_des");

            log.info("um_user:{},um_use_des:{}", results.size(), list.size());

            for (UmUser people : results) {
                log.info("Found <" + people + "> in the database.");
            }

            for (Object object : list) {
                log.info(object.toString());
            }
        }
    }
}