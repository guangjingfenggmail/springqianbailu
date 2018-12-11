package com.open.springqianbailu.dao;

import com.open.springqianbailu.model.Slider;

import java.util.List;

public interface SliderMapper extends AbsMapper {
    int insert(Slider record);

    int insertSelective(Slider record);

    List<Slider> selectAll();

    void insertBatch(List<Slider> list);

}