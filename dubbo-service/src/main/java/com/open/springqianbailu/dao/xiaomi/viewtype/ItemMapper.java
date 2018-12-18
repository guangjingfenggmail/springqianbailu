package com.open.springqianbailu.dao.xiaomi.viewtype;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.xiaomi.viewtype.Item;

import java.util.List;

public interface ItemMapper extends AbsMapper {
    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByViewType(String view_type);
}