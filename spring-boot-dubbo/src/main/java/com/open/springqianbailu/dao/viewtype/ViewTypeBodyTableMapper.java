package com.open.springqianbailu.dao.viewtype;

import com.open.springqianbailu.model.table.viewtype.ViewTypeBodyTable;

import java.util.List;

public interface ViewTypeBodyTableMapper {
    int insert(ViewTypeBodyTable record);

    int insertSelective(ViewTypeBodyTable record);

    List<ViewTypeBodyTable> selectById(Integer view_type_id);
}