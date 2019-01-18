package com.open.springqianbailu.dao.video;

import com.open.springqianbailu.model.rabbitmq.NovelMessage;
import com.open.springqianbailu.model.table.video.Video;

import java.util.HashMap;
import java.util.List;

public interface VideoMapper {
    int insert(Video record);

    int insertSelective(Video record);

    void dropTable();

    void createTable();

    List<Video> selectByMenuId(HashMap map);

    public void updateList();

    public int parseVideo(NovelMessage message);

    List<Video> selectByDate(HashMap map);

    int insertBatch(List<Video> list);

    void deleteByPageNo(HashMap map);

    List<Video> selectByHref(HashMap map);
}