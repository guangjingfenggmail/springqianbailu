package com.open.springqianbailu.service.viewtype;

import com.open.springqianbailu.model.table.viewtype.ViewTypeBodyTable;

public interface ViewTypeBodyTableService {
    int insert(ViewTypeBodyTable record);

    int insertSelective(ViewTypeBodyTable record);
}