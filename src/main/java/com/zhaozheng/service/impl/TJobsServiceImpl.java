package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.domain.TJobs;
import com.zhaozheng.mapper.TJobsMapper;
import com.zhaozheng.service.TJobsService;

import java.util.List;

@Service
public class TJobsServiceImpl implements TJobsService{

    @Resource
    private TJobsMapper tJobsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tJobsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TJobs record) {
        return tJobsMapper.insert(record);
    }

    @Override
    public int insertSelective(TJobs record) {
        return tJobsMapper.insertSelective(record);
    }

    @Override
    public TJobs selectByPrimaryKey(String id) {
        return tJobsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TJobs record) {
        return tJobsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TJobs record) {
        return tJobsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TJobs> findByAll(TJobs tJobs) {
        return tJobsMapper.findByAll(tJobs);
    }

}
