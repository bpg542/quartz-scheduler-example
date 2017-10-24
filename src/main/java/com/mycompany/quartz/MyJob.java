/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Implements the Quartz Job class to define what the job does i.e. it's task
 */
public class MyJob implements Job {

    public MyJob() {}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyJob is executing!");

        System.out.println("Fire Instance Id: " + jobExecutionContext.getFireInstanceId());
        System.out.println("Fire Time: " + jobExecutionContext.getFireTime());
        System.out.println("Next fire time: " + jobExecutionContext.getNextFireTime());
        System.out.println("Previous fire time: " + jobExecutionContext.getPreviousFireTime());
        System.out.println("Job run time: " + jobExecutionContext.getJobRunTime());
        System.out.println("Scheduled fire time: " + jobExecutionContext.getScheduledFireTime());

        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        System.out.println("Description: " + jobDetail.getDescription());
        System.out.println("Key: " + jobDetail.getKey());
    }
}
