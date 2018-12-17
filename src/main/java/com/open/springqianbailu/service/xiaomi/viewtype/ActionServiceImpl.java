package com.open.springqianbailu.service.xiaomi.viewtype;

import com.open.springqianbailu.dao.xiaomi.viewtype.ActionMapper;
import com.open.springqianbailu.interfaces.xiaomi.viewtype.ActionService;
import com.open.springqianbailu.model.xiaomi.viewtype.Action;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("actionService")
public class ActionServiceImpl extends AbsServiceImpl implements ActionService {

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
