package com.zhaozheng.service;

import com.zhaozheng.domain.TSchedule;

import java.util.List;

public interface TScheduleService{


    int deleteByPrimaryKey(String id);

    int insert(TSchedule record);

    int insertSelective(TSchedule record);

    TSchedule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSchedule record);

    int updateByPrimaryKey(TSchedule record);

    List<TSchedule> findByAll(TSchedule tSchedule);
}
