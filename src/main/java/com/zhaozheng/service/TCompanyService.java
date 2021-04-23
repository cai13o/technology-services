package com.zhaozheng.service;

import com.zhaozheng.domain.TCompany;

import java.util.List;

public interface TCompanyService {


    int deleteByPrimaryKey(String id);

    int insert(TCompany record);

    int insertSelective(TCompany record);

    TCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCompany record);

    int updateByPrimaryKey(TCompany record);

    List<TCompany> findByAll(TCompany tCompany);

}

