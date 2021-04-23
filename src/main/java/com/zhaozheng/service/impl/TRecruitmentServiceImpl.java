package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.mapper.TRecruitmentMapper;
import com.zhaozheng.domain.TRecruitment;
import com.zhaozheng.service.TRecruitmentService;
@Service
public class TRecruitmentServiceImpl implements TRecruitmentService{

    @Resource
    private TRecruitmentMapper tRecruitmentMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tRecruitmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TRecruitment record) {
        return tRecruitmentMapper.insert(record);
    }

    @Override
    public int insertSelective(TRecruitment record) {
        return tRecruitmentMapper.insertSelective(record);
    }

    @Override
    public TRecruitment selectByPrimaryKey(String id) {
        return tRecruitmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRecruitment record) {
        return tRecruitmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRecruitment record) {
        return tRecruitmentMapper.updateByPrimaryKey(record);
    }

}
