package com.open.springqianbailu.service.impl.viewtype;

import com.open.springqianbailu.dao.viewtype.ViewTypeTableMapper;
import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;
import com.open.springqianbailu.service.viewtype.ViewTypeTableService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ViewTypeTableService.class) //dubbo的service，注入接口
public class ViewTypeTableServiceImpl implements ViewTypeTableService {

    @Resource
    private ViewTypeTableMapper viewTypeTableMapper;

    @Override
    public int insert(ViewTypeTable record) {
        return viewTypeTableMapper.insert(record);
    }

    @Override
    public int insertSelective(ViewTypeTable record) {
        return viewTypeTableMapper.insertSelective(record);
    }

    @Override
    public List<ViewTypeTable> selectByViewType(String view_type) {
        return viewTypeTableMapper.selectByViewType(view_type);
    }
}
