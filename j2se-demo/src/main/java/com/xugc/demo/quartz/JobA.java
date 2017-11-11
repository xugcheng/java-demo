package com.xugc.demo.quartz;

import org.quartz.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by xuguocheng on 2017/8/31.
 */
@DisallowConcurrentExecution
public class JobA implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        try {
            JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
            String name = jobDataMap.getString("name");
            System.out.println(name + " start...");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(name + " end...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
