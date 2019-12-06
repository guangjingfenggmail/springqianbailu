package com.open.springqianbailu.dao.app;

import com.open.springqianbailu.model.app.AppLogs;

import java.util.List;

public interface AppLogsMapper {
    int insert(AppLogs record);

    int insertSelective(AppLogs record);


    List<AppLogs> selectAll();

}