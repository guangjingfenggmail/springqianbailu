package com.open.springqianbailu.service.quartz;

import org.quartz.SchedulerException;

public interface SchedulerService {

    /**
     * 开始执行所有任务
     *
     * @throws SchedulerException
     */
    void startAllJob() throws SchedulerException;


    /**
     * 开始执行job任务
     *
     * @param name
     * @param group
     * @return
     * @throws SchedulerException
     */
    void startJob(String name, String group) throws SchedulerException;

    /**
     * 获取Job信息
     *
     * @param name
     * @param group
     * @return
     * @throws SchedulerException
     */
    String getJobInfo(String name, String group) throws SchedulerException;

    /**
     * 修改某个任务的执行时间
     *
     * @param name
     * @param group
     * @param time
     * @return
     * @throws SchedulerException
     */
      boolean modifyJob(String name, String group, String time) throws SchedulerException;


    /**
     * 暂停所有任务
     *
     * @throws SchedulerException
     */
     void pauseAllJob() throws SchedulerException;


    /**
     * 暂停某个任务
     *
     * @param name
     * @param group
     * @throws SchedulerException
     */
     void pauseJob(String name, String group) throws SchedulerException;


    /**
     * 恢复所有任务
     *
     * @throws SchedulerException
     */
      void resumeAllJob() throws SchedulerException;


    /**
     * 恢复某个任务
     *
     * @param name
     * @param group
     * @throws SchedulerException
     */
      void resumeJob(String name, String group) throws SchedulerException;


    /**
     * 删除某个任务
     *
     * @param name
     * @param group
     * @throws SchedulerException
     */
      void deleteJob(String name, String group) throws SchedulerException;
}
