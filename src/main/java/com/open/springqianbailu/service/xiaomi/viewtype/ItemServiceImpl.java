package com.open.springqianbailu.service.xiaomi.viewtype;

import com.open.springqianbailu.dao.xiaomi.viewtype.ActionMapper;
import com.open.springqianbailu.dao.xiaomi.viewtype.ItemMapper;
import com.open.springqianbailu.interfaces.xiaomi.viewtype.ItemService;
import com.open.springqianbailu.model.xiaomi.viewtype.Action;
import com.open.springqianbailu.model.xiaomi.viewtype.Item;
import com.open.springqianbailu.rest.xiaomi.HomeTabRestService;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl extends AbsServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private ActionMapper actionMapper;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public int insert(Item record) {
        return itemMapper.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return itemMapper.insertSelective(record);
    }

    @Override
    public List<Item> selectByViewType(String view_type) {
        List<Item> list = (List<Item>) redisUtil.get("selectByViewType" + view_type);
        if (list == null || list.size() == 0) {
            list = itemMapper.selectByViewType(view_type);
            if (list == null || list.size() == 0) {
                list = HomeTabRestService.homeBanner(restTemplate, redisUtil);
                itemMapper.dropTable();
                itemMapper.createTable();

                actionMapper.dropTable();
                actionMapper.createTable();
                for (int i = 0; i < list.size(); i++) {
                    Item item = list.get(i);
                    item.setView_type(view_type);
                    itemMapper.insert(item);

                    Action action = item.getAction();
                    action.setItem_id(i + 1);
                    actionMapper.insert(action);
                }
            }
            redisUtil.set("selectByViewType" + view_type, list);
        }
        return list;
    }
}
