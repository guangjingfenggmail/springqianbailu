package com.open.springqianbailu.service.impl.viewtype;

import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.viewtype.ViewTypeTableMapper;
import com.open.springqianbailu.model.rabbitmq.Message;
import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;
import com.open.springqianbailu.rabbitmq.HomeSender;
import com.open.springqianbailu.rest.HomeTabRestService;
import com.open.springqianbailu.service.viewtype.ViewTypeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ViewTypeTableService.class) //dubbo的service，注入接口
public class ViewTypeTableServiceImpl implements ViewTypeTableService {

    @Resource
    private ViewTypeTableMapper viewTypeTableMapper;

    @Resource
    public RedisUtil redisUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HomeSender homeSender;

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
        List<ViewTypeTable> list = (List<ViewTypeTable>) redisUtil.get("ViewTypeTableService" + "selectByViewType" + view_type);
        if (list == null || list.size() == 0) {
            list = viewTypeTableMapper.selectByViewType(view_type);
            if (list == null || list.size() == 0) {
                list = HomeTabRestService.viewTypeHeads(restTemplate, redisUtil);
                redisUtil.set("ViewTypeTableService" + "selectByViewType" + view_type, list);
                if (list!=null && list.size()>0) {
                    Message msg = new Message();
                    msg.setParam2("home/appInfo");
                    msg.setParam("ViewTypeTableService" + "selectByViewType" + view_type);
                    homeSender.sendViewType(msg);
                }
            }
        }
        return list;
    }

    @Override
    public List<ViewTypeTable> getHomeSections(String data_type) {
        List<ViewTypeTable> list = (List<ViewTypeTable>) redisUtil.get("ItemService"+"getHomeSections");
        if (list == null || list.size() == 0) {
            list = viewTypeTableMapper.selectByDataType(data_type);
            if (list == null || list.size() == 0) {
                list = HomeTabRestService.homeSections(restTemplate, redisUtil);
                redisUtil.set("ItemService"+"getHomeSections", list);
                if (list != null && list.size() > 0) {
                    Message msg = new Message();
                    msg.setParam2("home/appInfo");
                    msg.setParam("ItemService"+"getHomeSections");
                    homeSender.sendViewType(msg);
                }
            }
        }
        return list;
    }
}
