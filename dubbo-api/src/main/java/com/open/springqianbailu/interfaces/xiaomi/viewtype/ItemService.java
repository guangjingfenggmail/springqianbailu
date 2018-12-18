package com.open.springqianbailu.interfaces.xiaomi.viewtype;

import com.open.springqianbailu.interfaces.AbsSevice;
import com.open.springqianbailu.model.xiaomi.viewtype.Item;

import java.util.List;

public interface ItemService extends AbsSevice {
    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByViewType(String view_type);
}