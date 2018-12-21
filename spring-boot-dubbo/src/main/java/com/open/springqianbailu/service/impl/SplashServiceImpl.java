package com.open.springqianbailu.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.dao.SplashMapper;
import com.open.springqianbailu.model.table.Splash;
import com.open.springqianbailu.service.SplashService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service(interfaceClass = SplashService.class) //dubbo的service，注入接口
public class SplashServiceImpl  implements SplashService {

    @Resource
    private SplashMapper splashMapper;

    @Override
    public int insert(Splash record) {
        return splashMapper.insert(record);
    }

    @Override
    public int insertSelective(Splash record) {
        return splashMapper.insertSelective(record);
    }

    @Override
    public List<Splash> selectAll() {
        return splashMapper.selectAll();
    }
}
