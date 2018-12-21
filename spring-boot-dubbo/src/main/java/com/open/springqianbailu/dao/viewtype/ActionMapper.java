package com.open.springqianbailu.dao.viewtype;


import com.open.springqianbailu.model.table.viewtype.Action;

import java.util.List;

public interface ActionMapper   {
    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByItemId(int item_id);


    void dropTable();

    void createTable();
}