package com.open.springqianbailu.service;


import com.open.springqianbailu.dao.SliderMapper;
import com.open.springqianbailu.interfaces.SliderService;
import com.open.springqianbailu.model.Slider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;
import static com.open.springqianbailu.redis.ConstUitls.REDIS_SLIDER_BANNDER_LIST_KEY;

@Service("sliderService")
public class SliderServiceImpl extends AbsServiceImpl implements SliderService {
    @Resource
    private SliderMapper sliderMapper;

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
        List<Slider> list = (List<Slider>) redisUtil.get(REDIS_SLIDER_BANNDER_LIST_KEY);
        if (list == null || list.size() == 0) {
            list = sliderMapper.selectAll();
            redisUtil.set(REDIS_SLIDER_BANNDER_LIST_KEY, list, REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
