package com.open.springqianbailu.dao.video;

import com.open.springqianbailu.model.table.video.VideoSource;

public interface VideoSourceMapper {
    int insert(VideoSource record);

    void dropTable();

    void createTable();

    VideoSource selectById(Integer videoId);
}