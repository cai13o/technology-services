package com.zhaozheng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zhaozheng.domain.TSystemAccount;
import com.zhaozheng.mapper.TSystemAccountMapper;
import com.zhaozheng.service.TSystemAccountService;

import java.util.List;

@Service
public class TSystemAccountServiceImpl implements TSystemAccountService{

    @Resource
    private TSystemAccountMapper tSystemAccountMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tSystemAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TSystemAccount record) {
        return tSystemAccountMapper.insert(record);
    }

    @Override
    public int insertSelective(TSystemAccount record) {
        return tSystemAccountMapper.insertSelective(record);
    }

    @Override
    public TSystemAccount selectByPrimaryKey(String id) {
        return tSystemAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSystemAccount record) {
        return tSystemAccountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TSystemAccount record) {
        return tSystemAccountMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TSystemAccount> findByAll(TSystemAccount tSystemAccount) {
        return tSystemAccountMapper.findByAll(tSystemAccount);
    }

    @Override
    public int updateByPassword(String id) {
        return tSystemAccountMapper.updatePasswordById("123456",id);
    }

    @Override
    public int updateByStatus(String id,String status) {
        return 0;
    }

}
