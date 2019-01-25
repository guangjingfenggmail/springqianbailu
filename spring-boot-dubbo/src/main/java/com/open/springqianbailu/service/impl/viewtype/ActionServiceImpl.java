package com.open.springqianbailu.service.impl.viewtype;


import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.dao.viewtype.ActionMapper;
import com.open.springqianbailu.model.table.viewtype.Action;
import com.open.springqianbailu.service.viewtype.ActionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service(interfaceClass = ActionService.class) //dubbo的service，注入接口
public class ActionServiceImpl  implements ActionService {

    @Resource
    private ActionMapper actionMapper;

    @Override
    public int insert(Action record) {
        return actionMapper.insert(record);
    }

    @Override
    public int insertSelective(Action record) {
        return actionMapper.insertSelective(record);
    }

    @Override
    public List<Action> selectByItemId(int item_id) {
        return actionMapper.selectByItemId(item_id);
    }
}
