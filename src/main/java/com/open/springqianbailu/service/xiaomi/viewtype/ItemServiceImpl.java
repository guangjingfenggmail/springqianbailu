package com.open.springqianbailu.service.xiaomi.viewtype;

import com.open.springqianbailu.dao.xiaomi.viewtype.ActionMapper;
import com.open.springqianbailu.dao.xiaomi.viewtype.ItemMapper;
import com.open.springqianbailu.interfaces.xiaomi.viewtype.ItemService;
import com.open.springqianbailu.model.xiaomi.viewtype.Item;
import com.open.springqianbailu.rabbitmq.xiaomi.HomeSender;
import com.open.springqianbailu.rabbitmq.xiaomi.Message;
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

    @Autowired
    private HomeSender homeSender;


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
                Message msg = new Message();
                msg.setParam(view_type);
                homeSender.sendViewType(msg);
            }
            redisUtil.set("selectByViewType" + view_type, list);
        }
        return list;
    }
}
