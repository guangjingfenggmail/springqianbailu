package com.open.springqianbailu.service.impl.viewtype;

import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.viewtype.ActionMapper;
import com.open.springqianbailu.dao.viewtype.ItemMapper;
import com.open.springqianbailu.model.bean.tab.Body;
import com.open.springqianbailu.model.bean.tab.ViewTypeBean;
import com.open.springqianbailu.model.rabbitmq.Message;
import com.open.springqianbailu.model.table.viewtype.Action;
import com.open.springqianbailu.model.table.viewtype.Item;
import com.open.springqianbailu.rabbitmq.HomeSender;
import com.open.springqianbailu.rest.HomeTabRestService;
import com.open.springqianbailu.service.viewtype.ActionService;
import com.open.springqianbailu.service.viewtype.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ItemService.class) //dubbo的service，注入接口
public class ItemServiceImpl  implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private ActionMapper actionMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HomeSender homeSender;

    @Resource
    public RedisUtil redisUtil;

    @Override
    public int insert(Item record) {
        return itemMapper.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return itemMapper.insertSelective(record);
    }

    @Override
    public List<Item> getHomeBanner(String view_type) {
        List<Item> list = (List<Item>) redisUtil.get("ItemService"+"getHomeBanner" + view_type);
        if (list == null || list.size() == 0) {
            list = itemMapper.selectByViewType(view_type);
            if (list == null || list.size() == 0) {
                list = HomeTabRestService.homeBanner(restTemplate, redisUtil);
                Message msg = new Message();
                msg.setParam(view_type);
                homeSender.sendViewType(msg);
            }
            redisUtil.set("ItemService"+"getHomeBanner" + view_type, list);
        }
        return list;
    }



    @Override
    public List<Item> selectByViewType(String view_type) {
        List<Item> list = (List<Item>) redisUtil.get("ItemService"+"selectByViewType" + view_type);
        if (list == null || list.size() == 0) {
            list = itemMapper.selectByViewType(view_type);
            redisUtil.set("ItemService"+"selectByViewType" + view_type, list);
        }
        return list;
    }

    @Override
    public List<ViewTypeBean> getHomeSections() {
        List<ViewTypeBean> list = (List<ViewTypeBean>) redisUtil.get("ItemService"+"getHomeSections");
        if (list == null || list.size() == 0) {
//            list = itemMapper.selectByViewType(view_type);
            if (list == null || list.size() == 0) {
                list = HomeTabRestService.homeSections(restTemplate, redisUtil);
                for (int i = 0; i < list.size(); i++) {
                    ViewTypeBean bean = list.get(i);
                    if (bean==null)
                        continue;
                    Body body = bean.getBody();
                    if (body==null){
                        continue;
                    }

                    List<Item> list1 =body.getItems();
                    if (list1==null || list1.size()==0)
                        continue;

                    for (int j=0;j<list1.size();j++) {
                        Item item = list1.get(j);
                        if(item==null)
                            continue;
                        item.setView_type(bean.getView_type());
                        itemMapper.insert(item);

                        Action action = item.getAction();
                        if (action==null)
                            continue;
                        action.setItem_id(item.getId());
                        actionMapper.insert(action);
                    }
                }
            }
            redisUtil.set("ItemService"+"selectByViewType", list);
        }
        return list;
    }
}
