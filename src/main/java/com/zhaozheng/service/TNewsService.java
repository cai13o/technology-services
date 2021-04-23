package com.zhaozheng.service;

import com.zhaozheng.domain.TNews;

import java.util.List;

public interface TNewsService{


    int deleteByPrimaryKey(String id);

    int insert(TNews record);

    int insertSelective(TNews record);

    TNews selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TNews record);

    int updateByPrimaryKey(TNews record);

    List<TNews> findByAll(TNews tNews);
}
