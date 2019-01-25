package com.open.springqianbailu.service.impl;

import com.open.springqianbailu.dao.TabCfgTableMapper;
import com.open.springqianbailu.model.table.TabCfgTable;
import com.open.springqianbailu.service.TabCfgTableService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = TabCfgTableService.class) //dubbo的service，注入接口
public class TabCfgTableServiceImpl  implements TabCfgTableService {

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

    @Override
    public List<TabCfgTable> selectAll() {
        return tabCfgTableMapper.selectAll();
    }
}
