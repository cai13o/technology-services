package com.zhaozheng.service;

import com.zhaozheng.domain.TResourceCenter;

import java.util.List;

public interface TResourceCenterService{


    int deleteByPrimaryKey(String id);

    int insert(TResourceCenter record);

    int insertSelective(TResourceCenter record);

    TResourceCenter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TResourceCenter record);

    int updateByPrimaryKey(TResourceCenter record);

    List<TResourceCenter> findByAll(TResourceCenter tResourceCenter);
}
