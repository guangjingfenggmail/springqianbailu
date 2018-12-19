package com.open.springqianbailu.service.xiaomi;

import com.open.springqianbailu.dao.xiaomi.SplashMapper;
import com.open.springqianbailu.interfaces.xiaomi.SplashService;
import com.open.springqianbailu.model.xiaomi.Splash;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SplashServiceImpl extends AbsServiceImpl implements SplashService {

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
