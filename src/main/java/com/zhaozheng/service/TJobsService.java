package com.zhaozheng.service;

import com.zhaozheng.domain.TJobs;

import java.util.List;

public interface TJobsService{


    int deleteByPrimaryKey(String id);

    int insert(TJobs record);

    int insertSelective(TJobs record);

    TJobs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TJobs record);

    int updateByPrimaryKey(TJobs record);

    List<TJobs> findByAll(TJobs tJobs);
}
