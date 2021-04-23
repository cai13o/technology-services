package com.zhaozheng.service;

import com.zhaozheng.domain.TJobWanted;
public interface TJobWantedService{


    int deleteByPrimaryKey(String id);

    int insert(TJobWanted record);

    int insertSelective(TJobWanted record);

    TJobWanted selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TJobWanted record);

    int updateByPrimaryKey(TJobWanted record);

}
