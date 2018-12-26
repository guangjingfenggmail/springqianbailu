package com.open.springqianbailu.service.impl.viewtype;

import com.open.springqianbailu.dao.viewtype.ItemMapper;
import com.open.springqianbailu.model.table.viewtype.Item;
import com.open.springqianbailu.service.viewtype.ItemService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ItemService.class) //dubbo的service，注入接口
public class ItemServiceImpl  implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public int insert(Item record) {
        return itemMapper.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return itemMapper.insertSelective(record);
    }


}
