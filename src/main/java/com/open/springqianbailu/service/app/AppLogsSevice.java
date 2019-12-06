package com.open.springqianbailu.service.app;

import com.open.springqianbailu.model.app.AppLogs;
import com.open.springqianbailu.service.AbsSevice;

import java.util.List;

public interface AppLogsSevice extends AbsSevice {
    int insert(AppLogs record);

    int insertSelective(AppLogs record);

    List<AppLogs> selectAll();

}