package com.open.springqianbailu.dao.viewtype;

import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;

import java.util.List;

public interface ViewTypeTableMapper {
    int insert(ViewTypeTable record);

    int insertSelective(ViewTypeTable record);

    void dropTable();

    void createTable();

    List<ViewTypeTable> selectByViewType(String view_type);

    void deleteByViewType(String view_type);

}