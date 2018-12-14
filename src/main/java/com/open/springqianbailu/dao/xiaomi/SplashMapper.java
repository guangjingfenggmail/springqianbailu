package com.open.springqianbailu.dao.xiaomi;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.xiaomi.Splash;

import java.util.List;

public interface SplashMapper extends AbsMapper {
    int insert(Splash record);

    int insertSelective(Splash record);

    List<Splash> selectAll();
}