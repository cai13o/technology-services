package com.zhaozheng.service;

import com.zhaozheng.domain.TDept;

import java.util.List;

public interface TDeptService{


    int deleteByPrimaryKey(String id);

    int insert(TDept record);

    int insertSelective(TDept record);

    TDept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TDept record);

    int updateByPrimaryKey(TDept record);

    List<TDept> findByAll(TDept tDept);
}
