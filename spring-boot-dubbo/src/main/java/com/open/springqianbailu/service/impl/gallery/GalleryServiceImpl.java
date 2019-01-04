package com.open.springqianbailu.service.impl.gallery;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.gallery.GalleryMapper;
import com.open.springqianbailu.documents.GalleryDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.gallery.Gallery;
import com.open.springqianbailu.rabbitmq.GallerySender;
import com.open.springqianbailu.service.gallery.GalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;


@Component
@Service(interfaceClass = GalleryService.class) //dubbo的service，注入接口
public class GalleryServiceImpl implements GalleryService {
    @Resource
    public RedisUtil redisUtil;

    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    private GalleryMapper galleryMapper;
    @Resource
    private SubMenuMapper subMenuMapper;

    @Autowired
    private GallerySender gallerySender;

    @Override
    public int insert(Gallery novel) {
        return galleryMapper.insert(novel);
    }

    @Override
    public int insertSelective(Gallery novel) {
        return galleryMapper.insertSelective(novel);
    }

    @Override
    public List<Gallery> selectByMenuId(HashMap reqMap) {
        List<Gallery> list = (List<Gallery>) redisUtil.get(TAG+reqMap.toString());
        if (list==null || list.size()==0){
            list = galleryMapper.selectByMenuId(reqMap);
            redisUtil.set(TAG+reqMap.toString(),list,REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public void updateList() {
        galleryMapper.dropTable();
        galleryMapper.createTable();
        List<SubMenu> subMenuList = subMenuMapper.selectByMenuId(0);
        for (SubMenu menu:subMenuList){
            List<Gallery> list =  GalleryDocmentDao.parseList(menu.getId(),menu.getHref());
            galleryMapper.insertBatch(list);
        }
    }

    @Override
    public int parseNovel(NovelMessage message) {
        gallerySender.send(message);
        return 0;
    }

    @Override
    public List<Gallery> selectByDate(HashMap map) {
        List<Gallery> list = (List<Gallery>) redisUtil.get(TAG+map.toString());
        if (list==null || list.size()==0){
            list = galleryMapper.selectByDate(map);
            redisUtil.set(TAG+map.toString(),list,REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
