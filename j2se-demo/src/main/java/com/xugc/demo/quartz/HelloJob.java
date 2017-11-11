package com.xugc.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * Created by xuguocheng on 2016/12/16.
 */
public class HelloJob implements Job {

    public HelloJob() {

    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobKey jobKey = context.getJobDetail().getKey();

        System.out.println("executing job :" + jobKey + " ,execution at " + context.getFireTime() + " ,fired by :" + context.getTrigger().getKey());

        context.setResult("Hello World!");
    }
}
