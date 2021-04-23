package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.domain.TDept;
import com.zhaozheng.mapper.TDeptMapper;
import com.zhaozheng.service.TDeptService;

import java.util.List;

@Service
public class TDeptServiceImpl implements TDeptService{

    @Resource
    private TDeptMapper tDeptMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TDept record) {
        return tDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(TDept record) {
        return tDeptMapper.insertSelective(record);
    }

    @Override
    public TDept selectByPrimaryKey(String id) {
        return tDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TDept record) {
        return tDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TDept record) {
        return tDeptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TDept> findByAll(TDept tDept) {
        return tDeptMapper.findByAll(tDept);
    }

}
