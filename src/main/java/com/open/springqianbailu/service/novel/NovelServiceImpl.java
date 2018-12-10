package com.open.springqianbailu.service.novel;

import com.open.springqianbailu.dao.novel.NovelMapper;
import com.open.springqianbailu.model.novel.Novel;
import com.open.springqianbailu.service.AbsServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.open.springqianbailu.redis.ConstUitls.REDIS_EXPIRE_TIME;


@Service("novelService")
public class NovelServiceImpl extends AbsServiceImpl implements NovelService {

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
    public List<Novel> selectByMenuId(HashMap reqMap) {
        List<Novel> list = (List<Novel>) redisUtil.get(reqMap.toString());
        if (list==null || list.size()==0){
            list = novelMapper.selectByMenuId(reqMap);
            redisUtil.set(reqMap.toString(),list,REDIS_EXPIRE_TIME);
        }
        return novelMapper.selectByMenuId(reqMap);
    }

}
