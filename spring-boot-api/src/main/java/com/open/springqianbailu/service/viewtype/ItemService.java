package com.open.springqianbailu.service.viewtype;


import com.open.springqianbailu.model.table.viewtype.Item;

public interface ItemService   {
    int insert(Item record);

    int insertSelective(Item record);


}