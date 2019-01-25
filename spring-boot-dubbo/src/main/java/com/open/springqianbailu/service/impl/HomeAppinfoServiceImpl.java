package com.open.springqianbailu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.HomeAppinfoTableMapper;
import com.open.springqianbailu.model.rabbitmq.Message;
import com.open.springqianbailu.model.table.HomeAppinfoTable;
import com.open.springqianbailu.rest.HomeTabRestService;
import com.open.springqianbailu.service.HomeAppinfoService;
import com.open.springqianbailu.service.impl.rabbitmq.HomeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service(interfaceClass = HomeAppinfoService.class) //dubbo的service，注入接口
public class HomeAppinfoServiceImpl  implements HomeAppinfoService {

    @Autowired
    private HomeAppinfoTableMapper homeAppinfoTableMapper;

    @Autowired
    private HomeSender homeSender;

    @Resource
    public RedisUtil redisUtil;


    @Override
    public int insert(HomeAppinfoTable record) {
        return homeAppinfoTableMapper.insert(record);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int insertSelective(HomeAppinfoTable record) {
        return homeAppinfoTableMapper.insertSelective(record);
    }

    @Override
    public List<HomeAppinfoTable> selectAll() {
        List<HomeAppinfoTable> list = (List<HomeAppinfoTable>) redisUtil.get("HomeAppinfoService" + "selectAll");
        if (list == null || list.size() == 0) {
            list = homeAppinfoTableMapper.selectAll();
            if (list == null || list.size() == 0) {
                list =  HomeTabRestService.homeAppInfo(restTemplate,redisUtil);
                if (list!=null && list.size()>0) {
                    homeSender.send(new Message());
                }
            }
            redisUtil.set("HomeAppinfoService" + "selectAll",list);
        }
        return list;
    }
}
