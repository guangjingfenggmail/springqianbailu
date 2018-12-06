package com.open.springqianbailu.service.novel;

import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.model.novel.Novel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Service("novelService")
public class NovelServiceImpl implements NovelService {

    @Resource
    private NovelMapper novelMapper;

    @Override
    public int insert(Novel novel) {
        return novelMapper.insert(novel);
    }

    @Override
    public int insertSelective(Novel novel) {
        return novelMapper.insertSelective(novel);
    }

    @Override
    public List<Novel> selectByMenuId(HashMap map) {
        return novelMapper.selectByMenuId(map);
    }

}
