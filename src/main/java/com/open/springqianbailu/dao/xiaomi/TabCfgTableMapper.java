package com.open.springqianbailu.dao.xiaomi;

import com.open.springqianbailu.dao.AbsMapper;
import com.open.springqianbailu.model.xiaomi.TabCfgTable;

public interface TabCfgTableMapper extends AbsMapper {
    int insert(TabCfgTable record);

    int insertSelective(TabCfgTable record);
}