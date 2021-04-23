package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.mapper.TJobWantedMapper;
import com.zhaozheng.domain.TJobWanted;
import com.zhaozheng.service.TJobWantedService;
@Service
public class TJobWantedServiceImpl implements TJobWantedService{

    @Resource
    private TJobWantedMapper tJobWantedMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tJobWantedMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TJobWanted record) {
        return tJobWantedMapper.insert(record);
    }

    @Override
    public int insertSelective(TJobWanted record) {
        return tJobWantedMapper.insertSelective(record);
    }

    @Override
    public TJobWanted selectByPrimaryKey(String id) {
        return tJobWantedMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TJobWanted record) {
        return tJobWantedMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TJobWanted record) {
        return tJobWantedMapper.updateByPrimaryKey(record);
    }

}
