package com.open.springqianbailu.dao.viewtype;


import com.open.springqianbailu.model.table.viewtype.Item;

import java.util.List;

public interface ItemMapper  {
    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByViewType(String view_type);

    List<Item> selectById(Integer view_type_id);

    void dropTable();

    void createTable();
}