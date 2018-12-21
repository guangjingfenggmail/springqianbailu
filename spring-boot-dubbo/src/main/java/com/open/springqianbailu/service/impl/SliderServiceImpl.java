package com.open.springqianbailu.service.impl;


import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SliderMapper;
import com.open.springqianbailu.model.table.Slider;
import com.open.springqianbailu.service.SliderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;


@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = SliderService.class) //dubbo的service，注入接口
public class SliderServiceImpl   implements SliderService {
    @Resource
    private SliderMapper sliderMapper;

    @Resource
    public RedisUtil redisUtil;

    @Override
    public int insert(Slider record) {
        return sliderMapper.insert(record);
    }

    @Override
    public int insertSelective(Slider record) {
        return sliderMapper.insertSelective(record);
    }

    @Override
    public List<Slider> selectAll() {
        List<Slider> list = (List<Slider>) redisUtil.get("SliderService"+"selectAll");
        if (list == null || list.size() == 0) {
            list = sliderMapper.selectAll();
//            if (list == null || list.size() == 0) {
//                list = MenuDocumentDao.parseSlider();
//                sliderMapper.dropTable();
//                sliderMapper.createTable();
//                sliderMapper.insertBatch(list);
//
//            }
            redisUtil.set("SliderService"+"selectAll", list, REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
