package com.open.springqianbailu.dao;


import com.open.springqianbailu.model.table.Splash;

import java.util.List;

public interface SplashMapper   {
    int insert(Splash record);

    int insertSelective(Splash record);

    List<Splash> selectAll();

    void dropTable();

    void createTable();
}