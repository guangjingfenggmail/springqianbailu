package com.open.springqianbailu.service;


import com.open.springqianbailu.model.table.Slider;

import java.util.List;

public interface SliderService  {

    int insert(Slider record);

    int insertSelective(Slider record);

    List<Slider> selectAll();
}
