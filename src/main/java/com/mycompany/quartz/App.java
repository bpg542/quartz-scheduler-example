package com.mycompany.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class App {

    public static void main( String[] args ) {
        try {
            // Schedulers are created from Factories
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // Start the scheduler
            scheduler.start();


        } catch (SchedulerException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
