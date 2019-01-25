package com.open.springqianbailu.service;


import com.open.springqianbailu.model.table.Splash;

import java.util.List;

public interface SplashService  {
    int insert(Splash record);

    int insertSelective(Splash record);

    List<Splash> selectAll();
}