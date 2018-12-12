package com.open.springqianbailu.dao.xiaomi;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.xiaomi.Splash;

public interface SplashMapper extends AbsMapper {
    int insert(Splash record);

    int insertSelective(Splash record);
}