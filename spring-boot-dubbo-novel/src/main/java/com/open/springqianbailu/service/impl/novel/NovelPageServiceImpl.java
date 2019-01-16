package com.open.springqianbailu.service.impl.novel;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.novel.NovelPageMapper;
import com.open.springqianbailu.model.table.novel.NovelPage;
import com.open.springqianbailu.service.novel.NovelPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service(interfaceClass = NovelPageService.class) //dubbo的service，注入接口
public class NovelPageServiceImpl implements NovelPageService {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;

    @Resource
    private NovelPageMapper novelPageMapper;

    @Override
    public int insert(NovelPage record) {
        novelPageMapper.insert(record);
        return 0;
    }
}