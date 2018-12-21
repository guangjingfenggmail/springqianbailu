//package com.open.springqianbailu.quartz;
//
//
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//
//@Configuration
//public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent>{
//    @Autowired
//    private QuartzScheduler2 quartzScheduler2;
//
//    /**
//     * 初始启动quartz
//     */
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        try {
//            quartzScheduler2.startJob();
//            System.out.println("任务已经启动...");
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 初始注入scheduler
//     * @return
//     * @throws SchedulerException
//     */
//    @Bean
//    public Scheduler scheduler() throws SchedulerException{
//        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
//        return schedulerFactoryBean.getScheduler();
//    }
//
//}
