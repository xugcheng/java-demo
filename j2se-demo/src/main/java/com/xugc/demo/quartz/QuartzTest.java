package com.xugc.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by xuguocheng on 2016/12/16.
 */
public class QuartzTest {

    public static void main(String[] args) {
        try {

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail jobDetail = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // compute a time that is on the next round minute
            Date runTime = evenMinuteDate(new Date());

            // Trigger the job to run on the next round minute
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(5))
                    .startAt(runTime)
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

            scheduler.start();

            Thread.sleep(700L * 1000L);

            scheduler.shutdown(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


