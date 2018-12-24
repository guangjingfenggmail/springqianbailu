package com.open.springqianbailu.service.viewtype;


import com.open.springqianbailu.model.bean.tab.ViewTypeBean;
import com.open.springqianbailu.model.table.viewtype.Item;

import java.util.List;

public interface ItemService   {
    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByViewType(String view_type);

    List<ViewTypeBean> getHomeSections();
}