package com.open.springqianbailu.interfaces.xiaomi.viewtype;

import com.open.springqianbailu.interfaces.AbsSevice;
import com.open.springqianbailu.model.xiaomi.viewtype.Action;

import java.util.List;

public interface ActionService extends AbsSevice {
    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByItemId(int item_id);
}