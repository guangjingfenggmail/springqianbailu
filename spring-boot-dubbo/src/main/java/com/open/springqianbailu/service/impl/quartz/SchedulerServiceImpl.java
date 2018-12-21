package com.open.springqianbailu.service.impl.quartz;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.quartz.QuartzScheduler2;
import com.open.springqianbailu.service.impl.jobs.MenuQuartzJob;
import com.open.springqianbailu.service.quartz.SchedulerService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
@Service(interfaceClass = SchedulerService.class) //dubbo的service，注入接口
public class SchedulerServiceImpl implements SchedulerService {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Autowired
    private QuartzScheduler2 quartzScheduler2;

    @Override
    public void startAllJob() throws SchedulerException {
        logger.info(TAG+"=====startAllJob=========");
        quartzScheduler2.startJob();
    }

    @Override
    public void startJob(String name, String group) throws SchedulerException {
        logger.info(TAG+"=====startJob=========name=="+name+";group==="+group);
        quartzScheduler2.startJob(MenuQuartzJob.class,"0/5 * * * * ?",name,group);
    }

    @Override
    public String getJobInfo(String name, String group) throws SchedulerException {
        logger.info(TAG+"=====getJobInfo=========name=="+name+";group==="+group);
        return quartzScheduler2.getJobInfo(name, group);
    }

    @Override
    public boolean modifyJob(String name, String group, String time) throws SchedulerException {
        logger.info(TAG+"=====modifyJob=========name=="+name+";group==="+group+";time==="+time);
        return quartzScheduler2.modifyJob(name, group, time);
    }

    @Override
    public void pauseAllJob() throws SchedulerException {
        logger.info(TAG+"=====pauseAllJob===========");
        quartzScheduler2.pauseAllJob();
    }

    @Override
    public void pauseJob(String name, String group) throws SchedulerException {
        logger.info(TAG+"=====pauseJob=========name=="+name+";group==="+group);
        quartzScheduler2.pauseJob(name, group);
    }

    @Override
    public void resumeAllJob() throws SchedulerException {
        logger.info(TAG+"=====resumeAllJob===========");
        quartzScheduler2.resumeAllJob();
    }

    @Override
    public void resumeJob(String name, String group) throws SchedulerException {
        logger.info(TAG+"=====resumeJob=========name=="+name+";group==="+group);
        quartzScheduler2.resumeJob(name,group);
    }

    @Override
    public void deleteJob(String name, String group) throws SchedulerException {
        logger.info(TAG+"=====deleteJob=========name=="+name+";group==="+group);
        quartzScheduler2.deleteJob(name, group);
    }
}
