package com.open.springqianbailu.service.impl.video;

import com.alibaba.dubbo.config.annotation.Service;
import com.open.springqianbailu.RedisUtil;
import com.open.springqianbailu.dao.SubMenuMapper;
import com.open.springqianbailu.dao.video.VideoMapper;
import com.open.springqianbailu.dao.video.VideoSourceMapper;
import com.open.springqianbailu.documents.VideoDocmentDao;
import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.SubMenu;
import com.open.springqianbailu.model.table.video.Video;
import com.open.springqianbailu.model.table.video.VideoSource;
import com.open.springqianbailu.rabbitmq.VideoSender;
import com.open.springqianbailu.service.video.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.RedisUtil.REDIS_EXPIRE_TIME;


@Component
@Service(interfaceClass = VideoService.class) //dubbo的service，注入接口
public class VideoServiceImpl implements VideoService {
    @Resource
    public RedisUtil redisUtil;

    public String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    @Resource
    private VideoMapper videoMapper;
    @Resource
    private SubMenuMapper subMenuMapper;

    @Autowired
    private VideoSender videoSender;

    @Autowired
    private VideoSourceMapper videoSourceMapper;

    @Override
    public int insert(Video novel) {
        return videoMapper.insert(novel);
    }

    @Override
    public List<Video> selectByMenuId(HashMap reqMap) {
        List<Video> list = (List<Video>) redisUtil.get(TAG + "selectByMenuId" + reqMap.toString());
        if (list == null || list.size() == 0) {
            list = videoMapper.selectByMenuId(reqMap);
            redisUtil.set(TAG + "selectByMenuId" + reqMap.toString(), list, REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public void updateList() {
        videoMapper.dropTable();
        videoMapper.createTable();
        List<SubMenu> subMenuList = subMenuMapper.selectByMenuId(0);
        for (SubMenu menu : subMenuList) {
            List<Video> list = VideoDocmentDao.parseList(menu.getId(), menu.getHref());
            videoMapper.insertBatch(list);
        }
    }

    @Override
    public int parseVideo(NovelMessage message) {
        videoSender.send(message);
        return 0;
    }

    @Override
    public List<Video> selectByDate(HashMap map) {
        List<Video> list = (List<Video>) redisUtil.get(TAG + "selectByDate" + map.toString());
        if (list == null || list.size() == 0) {
            list = videoMapper.selectByDate(map);
            redisUtil.set(TAG + "selectByDate" + map.toString(), list, REDIS_EXPIRE_TIME);
        }
        return list;
    }

    @Override
    public List<Video> getVideoSource(HashMap map) {
        List<Video> list = (List<Video>) redisUtil.get(TAG + "getVideoSource" + map.toString());
        if (list == null || list.size() == 0) {
            list = videoMapper.selectByHref(map);
            if (list != null && list.size() > 0) {
                Video video = list.get(0);
                if (video!=null){
                    VideoSource source = VideoDocmentDao.parseVideoSource(map.get("href").toString());
                    source.setVideo_id(video.getId());
                    video.setSource(source);

                    videoSourceMapper.insert(source);
                }
            }
            redisUtil.set(TAG + "getVideoSource" + map.toString(), list, REDIS_EXPIRE_TIME);
        }
        return list;
    }
}
