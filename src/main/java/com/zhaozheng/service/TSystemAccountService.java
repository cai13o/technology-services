package com.zhaozheng.service;

import com.zhaozheng.domain.TSystemAccount;

import java.util.List;

public interface TSystemAccountService{


    int deleteByPrimaryKey(String id);

    int insert(TSystemAccount record);

    int insertSelective(TSystemAccount record);

    TSystemAccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSystemAccount record);

    int updateByPrimaryKey(TSystemAccount record);

    List<TSystemAccount> findByAll(TSystemAccount tSystemAccount);

    int updateByPassword(String id);

    int updateByStatus(String id,String status);
}
