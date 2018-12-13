package com.open.springqianbailu.service.xiaomi;

import com.open.springqianbailu.dao.xiaomi.TabCfgTableMapper;
import com.open.springqianbailu.interfaces.xiaomi.TabCfgTableService;
import com.open.springqianbailu.model.xiaomi.TabCfgTable;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tabCfgTableService")
public class TabCfgTableServiceImpl extends AbsServiceImpl implements TabCfgTableService
{

    @Resource
    private TabCfgTableMapper tabCfgTableMapper;

    @Override
    public int insert(TabCfgTable record) {
        return tabCfgTableMapper.insert(record);
    }

    @Override
    public int insertSelective(TabCfgTable record) {
        return tabCfgTableMapper.insertSelective(record);
    }

    @Override
    public void dropTable() {
        tabCfgTableMapper.dropTable();
    }

    @Override
    public void createTable() {
        tabCfgTableMapper.createTable();
    }
}
