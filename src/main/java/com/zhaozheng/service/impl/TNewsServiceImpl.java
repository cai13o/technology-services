package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.domain.TNews;
import com.zhaozheng.mapper.TNewsMapper;
import com.zhaozheng.service.TNewsService;

import java.util.List;

@Service
public class TNewsServiceImpl implements TNewsService{

    @Resource
    private TNewsMapper tNewsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TNews record) {
        return tNewsMapper.insert(record);
    }

    @Override
    public int insertSelective(TNews record) {
        return tNewsMapper.insertSelective(record);
    }

    @Override
    public TNews selectByPrimaryKey(String id) {
        return tNewsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TNews record) {
        return tNewsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TNews record) {
        return tNewsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TNews> findByAll(TNews tNews) {
        return this.tNewsMapper.findByAll(tNews);
    }

}
