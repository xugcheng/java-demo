package com.xugc.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * quartz并发测试
 * Created by xuguocheng on 2017/8/31.
 */
public class QuartzConcurrencyTest {

    public static void main(String[] args) throws Exception {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobA1 = JobBuilder.newJob(JobA.class)
                .usingJobData("name", "A1")
                .build();

        JobDetail jobA2 = JobBuilder.newJob(JobA.class)
                .usingJobData("name", "A2")
                .build();

        JobDetail jobB1 = JobBuilder.newJob(JobB.class)
                .usingJobData("name", "B1")
                .build();

        JobDetail jobB2 = JobBuilder.newJob(JobB.class)
                .usingJobData("name", "B2")
                .build();


        Trigger triggerA1 = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(5))
                .startNow()
                .build();

        Trigger triggerA2 = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(5))
                .startNow()
                .build();

        Trigger triggerB1 = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(5))
                .startNow()
                .build();

        Trigger triggerB2 = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(5))
                .startNow()
                .build();

        scheduler.scheduleJob(jobA1, triggerA1);
        scheduler.scheduleJob(jobA2, triggerA2);
        scheduler.scheduleJob(jobB1, triggerB1);
        scheduler.scheduleJob(jobB2, triggerB2);


        scheduler.start();

        TimeUnit.SECONDS.sleep(300);

        scheduler.shutdown(true);
    }
}
