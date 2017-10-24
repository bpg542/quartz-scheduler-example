package com.mycompany.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class App {

    public static void main( String[] args ) {
        try {
            // Schedulers are created from Factories
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // Start the scheduler
            scheduler.start();

            /*
             * Scheduling those jobs with Triggers that define what time the jobs should run
             */

            // Defining the job (and tying it to MyJob.class)
            JobDetail jobDetail = newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

            // Trigger the job to run at what time and frequency
            Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group 1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInMilliseconds(1000L).repeatForever())
                .build();

            // tell scheduler to schedule the job using the trigger
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
