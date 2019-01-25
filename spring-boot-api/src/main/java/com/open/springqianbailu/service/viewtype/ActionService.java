package com.open.springqianbailu.service.viewtype;


import com.open.springqianbailu.model.table.viewtype.Action;

import java.util.List;

public interface ActionService  {
    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByItemId(int item_id);
}