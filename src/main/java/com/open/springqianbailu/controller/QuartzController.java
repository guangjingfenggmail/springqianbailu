package com.open.springqianbailu.controller;


import com.open.springqianbailu.quartz.QuartzScheduler2;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/quartz")
public class QuartzController {

    @Autowired
    private QuartzScheduler2 quartzScheduler2;

    @ApiOperation(value = "start", notes = "start定时任务")
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void startQuartzJob() {
        try {
            quartzScheduler2.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "info", notes = "获取定时任务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "group", value = "group", required = true, dataType = "String", paramType = "query")})
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getQuartzJob(String name,  String group) {
        String info = null;
        try {
            info = quartzScheduler2.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    @ApiOperation(value = "modify", notes = "modify定时任务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "group", value = "group", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "time", value = "time", required = true, dataType = "String", paramType = "query")})
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        try {
            flag = quartzScheduler2.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @ApiOperation(value = "pause", notes = "pause定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "group", value = "group", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/pause",method = RequestMethod.GET)
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzScheduler2.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "pauseAll", notes = "v定时任务")
    @RequestMapping(value = "/pauseAll",method = RequestMethod.POST)
    public void pauseAllQuartzJob() {
        try {
            quartzScheduler2.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "delete", notes = "delete定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "group", value = "group", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public void deleteJob(String name, String group) {
        try {
            quartzScheduler2.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
