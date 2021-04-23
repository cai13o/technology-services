package com.zhaozheng.service;

import com.zhaozheng.domain.TRecruitment;
public interface TRecruitmentService{


    int deleteByPrimaryKey(String id);

    int insert(TRecruitment record);

    int insertSelective(TRecruitment record);

    TRecruitment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRecruitment record);

    int updateByPrimaryKey(TRecruitment record);

}
