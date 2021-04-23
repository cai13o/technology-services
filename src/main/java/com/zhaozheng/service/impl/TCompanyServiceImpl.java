package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.domain.TCompany;
import com.zhaozheng.mapper.TCompanyMapper;
import com.zhaozheng.service.TCompanyService;

import java.util.List;

@Service
public class TCompanyServiceImpl implements TCompanyService {

    @Resource
    private TCompanyMapper tCompanyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tCompanyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TCompany record) {
        return tCompanyMapper.insert(record);
    }

    @Override
    public int insertSelective(TCompany record) {
        return tCompanyMapper.insertSelective(record);
    }

    @Override
    public TCompany selectByPrimaryKey(String id) {
        return tCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TCompany record) {
        return tCompanyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TCompany record) {
        return tCompanyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TCompany> findByAll(TCompany tCompany) {
        return tCompanyMapper.findByAll(tCompany);
    }

}

