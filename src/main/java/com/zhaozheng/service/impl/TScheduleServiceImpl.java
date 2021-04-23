package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.domain.TSchedule;
import com.zhaozheng.mapper.TScheduleMapper;
import com.zhaozheng.service.TScheduleService;

import java.util.List;

@Service
public class TScheduleServiceImpl implements TScheduleService{

    @Resource
    private TScheduleMapper tScheduleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tScheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TSchedule record) {
        return tScheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(TSchedule record) {
        return tScheduleMapper.insertSelective(record);
    }

    @Override
    public TSchedule selectByPrimaryKey(String id) {
        return tScheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSchedule record) {
        return tScheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TSchedule record) {
        return tScheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TSchedule> findByAll(TSchedule tSchedule) {
        return this.tScheduleMapper.findByAll(tSchedule);
    }

}
