package com.open.springqianbailu.interfaces.xiaomi;

import com.open.springqianbailu.interfaces.AbsSevice;
import com.open.springqianbailu.model.xiaomi.Splash;

public interface SplashService extends AbsSevice {
    int insert(Splash record);

    int insertSelective(Splash record);
}