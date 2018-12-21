package com.open.springqianbailu.quartz;

import com.open.springqianbailu.interfaces.jsoup.JsoupMenuService;
import com.open.springqianbailu.service.jsoup.JsoupMenuServiceImpl;
import com.open.springqianbailu.service.task.MenuAsyncTask;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 实现Job接口
 * @author yvan
 *
 */
@Component
public class SchedulerQuartzJob1 implements Job{
    private void before(){
        System.out.println("任务开始执行");
    }

//    @Resource
//    private JsoupMenuServiceImpl jsoupMenuService;

    @Resource
    private MenuAsyncTask menuAsyncTask;


    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        System.out.println("开始："+System.currentTimeMillis());
        // TODO 业务
//        jsoupMenuService.updateMenu();
        try {
            menuAsyncTask.doTaskMenu();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("结束："+System.currentTimeMillis());
        after();
    }

    private void after(){
        System.out.println("任务开始执行");
    }

}