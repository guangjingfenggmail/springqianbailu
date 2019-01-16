package com.open.springqianbailu.service.impl.gallery;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.gallery.GalleryImageMapper;
import com.open.springqianbailu.dao.gallery.GalleryMapper;
import com.open.springqianbailu.documents.GalleryDocmentDao;
import com.open.springqianbailu.model.table.gallery.Gallery;
import com.open.springqianbailu.model.table.gallery.GalleryImage;
import com.open.springqianbailu.service.gallery.GalleryImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Component
@Service(interfaceClass = GalleryImageService.class) //dubbo的service，注入接口
public class GalleryImageServiceImpl implements GalleryImageService {
    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    public RedisUtil redisUtil;

    @Resource
    private GalleryImageMapper galleryImageMapper;

    @Resource
    private GalleryMapper galleryMapper;

    @Override
    public int insert(GalleryImage record) {
        galleryImageMapper.insert(record);
        return 0;
    }

    @Override
    public List<GalleryImage> selectImage(String href, String page) {
        List<GalleryImage> list = (List<GalleryImage>) redisUtil.get("GalleryImageService" + "selectImage" + href + page);
        if (list == null || list.size() == 0) {
            HashMap map = new HashMap();
            map.put("page",page);
            map.put("href",href);
            List<Gallery> novelList = galleryMapper.selectByHref(map);
            Gson gson = new Gson();
            logger.info(TAG+"gallery=="+gson.toJson(novelList));
            if (novelList!=null && novelList.size()>0){
                Gallery novel = novelList.get(0);
                list = novel.getImageList();
                if (list == null || list.size() == 0) {
                    Gallery articleBean = GalleryDocmentDao.parseImageList(href, Integer.parseInt(page));
                    if (articleBean != null) {
                        list = articleBean.getImageList();
                        if (list != null && list.size() > 0) {
                            for (GalleryImage article : list) {
                                article.setGallery_id(novel.getId());
                                galleryImageMapper.insert(article);
                            }
                        }
                    }
                }
            }
            redisUtil.set("GalleryImageService" + "selectImage" + href + page, list);
        }
        return list;
    }
}