package com.open.springqianbailu.interfaces;

import com.open.springqianbailu.model.Slider;

import java.util.List;

public interface SliderService extends AbsSevice{

    int insert(Slider record);

    int insertSelective(Slider record);

    List<Slider> selectAll();
}
