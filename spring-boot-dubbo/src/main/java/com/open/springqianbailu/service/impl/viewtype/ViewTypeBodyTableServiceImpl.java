package com.open.springqianbailu.service.impl.viewtype;

import com.open.springqianbailu.dao.viewtype.ViewTypeBodyTableMapper;
import com.open.springqianbailu.model.table.viewtype.ViewTypeBodyTable;
import com.open.springqianbailu.service.viewtype.ViewTypeBodyTableService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ViewTypeBodyTableService.class) //dubbo的service，注入接口
public class ViewTypeBodyTableServiceImpl implements ViewTypeBodyTableService {
    @Resource
    private ViewTypeBodyTableMapper viewTypeBodyTableMapper;

    @Override
    public int insert(ViewTypeBodyTable record) {
        return viewTypeBodyTableMapper.insert(record);
    }

    @Override
    public int insertSelective(ViewTypeBodyTable record) {
        return viewTypeBodyTableMapper.insertSelective(record);
    }
}