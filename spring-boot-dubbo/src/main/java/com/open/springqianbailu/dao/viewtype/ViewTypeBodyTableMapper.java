package com.open.springqianbailu.dao.viewtype;

import com.open.springqianbailu.model.table.viewtype.ViewTypeBodyTable;

public interface ViewTypeBodyTableMapper {
    int insert(ViewTypeBodyTable record);

    int insertSelective(ViewTypeBodyTable record);
}