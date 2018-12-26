package com.open.springqianbailu.service.viewtype;

import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;

import java.util.List;

public interface ViewTypeTableService {
    int insert(ViewTypeTable record);

    int insertSelective(ViewTypeTable record);

    List<ViewTypeTable> selectByViewType(String view_type);
}