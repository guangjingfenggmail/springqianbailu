package com.open.springqianbailu.dao.xiaomi.viewtype;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.xiaomi.viewtype.Action;

import java.util.List;

public interface ActionMapper extends AbsMapper {
    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByItemId(int item_id);
}