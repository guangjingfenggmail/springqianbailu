package com.open.springqianbailu.service.app;


import com.open.springqianbailu.dao.app.AppLogsMapper;
import com.open.springqianbailu.model.app.AppLogs;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_APPLOG_LIST_KEY;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;

@Service("appLogsSevice")
public class AppLogsSeviceImpl extends AbsServiceImpl implements AppLogsSevice {
    @Resource
    AppLogsMapper appLogsMapper;

    @Override
    public int insert(AppLogs record) {
        return appLogsMapper.insert(record);
    }

    @Override
    public int insertSelective(AppLogs record) {
        return appLogsMapper.insertSelective(record);
    }

    @Override
    public List<AppLogs> selectAll() {
//        List<AppLogs> list = (List<AppLogs>) redisUtil.get(REDIS_APPLOG_LIST_KEY);
//        if (list == null || list.size() == 0) {
        List<AppLogs> list = appLogsMapper.selectAll();
        redisUtil.set(REDIS_APPLOG_LIST_KEY, list, REDIS_EXPIRE_TIME);
//        }
        return list;
    }
}