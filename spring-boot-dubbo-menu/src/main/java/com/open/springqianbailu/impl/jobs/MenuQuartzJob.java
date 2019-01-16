package com.open.springqianbailu.impl.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 实现Job接口
 *
 */
@Component
public class MenuQuartzJob implements Job{
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    private void before(){
        logger.info(TAG+"任务开始执行");
    }

//    @Resource
//    private JsoupMenuServiceImpl jsoupMenuService;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        logger.info(TAG+"开始："+System.currentTimeMillis());
        // TODO 业务
        try {
//            jsoupMenuService.updateMenu();
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info(TAG+"结束："+System.currentTimeMillis());
        after();
    }

    private void after(){
        logger.info(TAG+"任务开始执行");
    }

}