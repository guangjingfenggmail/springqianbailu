package com.open.springqianbailu.dao;


import com.open.springqianbailu.model.table.Slider;

import java.util.List;

public interface SliderMapper  {
    int insert(Slider record);

    int insertSelective(Slider record);

    List<Slider> selectAll();

    void insertBatch(List<Slider> list);

    void dropTable();

    void createTable();

}