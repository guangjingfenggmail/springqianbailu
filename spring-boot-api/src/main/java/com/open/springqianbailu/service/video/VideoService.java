package com.open.springqianbailu.service.video;

import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.video.Video;

import java.util.HashMap;
import java.util.List;

public interface VideoService {
    int insert(Video record);

    List<Video> selectByMenuId(HashMap map);

    public void updateList();

    public int parseVideo(NovelMessage message);

    List<Video> selectByDate(HashMap map);

    List<Video> getVideoSource(HashMap map);

    int insertBatch(List<Video> list);

    void deleteByPageNo(HashMap map);
}