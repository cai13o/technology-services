package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.mapper.TResourceCenterMapper;
import com.zhaozheng.domain.TResourceCenter;
import com.zhaozheng.service.TResourceCenterService;

import java.util.List;

@Service
public class TResourceCenterServiceImpl implements TResourceCenterService{

    @Resource
    private TResourceCenterMapper tResourceCenterMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tResourceCenterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TResourceCenter record) {
        return tResourceCenterMapper.insert(record);
    }

    @Override
    public int insertSelective(TResourceCenter record) {
        return tResourceCenterMapper.insertSelective(record);
    }

    @Override
    public TResourceCenter selectByPrimaryKey(String id) {
        return tResourceCenterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TResourceCenter record) {
        return tResourceCenterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TResourceCenter record) {
        return tResourceCenterMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TResourceCenter> findByAll(TResourceCenter tResourceCenter) {
        return this.tResourceCenterMapper.findByAll(tResourceCenter);
    }

}
