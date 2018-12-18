package com.open.springqianbailu.service.xiaomi;

import com.open.springqianbailu.dao.xiaomi.HomeAppinfoTableMapper;
import com.open.springqianbailu.interfaces.xiaomi.HomeAppinfoService;
import com.open.springqianbailu.model.xiaomi.HomeAppinfoTable;
import com.open.springqianbailu.rabbitmq.xiaomi.HomeSender;
import com.open.springqianbailu.rabbitmq.xiaomi.Message;
import com.open.springqianbailu.rest.xiaomi.HomeTabRestService;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service("homeAppinfoService")
public class HomeAppinfoServiceImpl extends AbsServiceImpl implements HomeAppinfoService {

    @Resource
    private HomeAppinfoTableMapper homeAppinfoTableMapper;

    @Autowired
    private HomeSender homeSender;


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
