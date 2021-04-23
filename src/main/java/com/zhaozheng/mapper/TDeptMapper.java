package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import com.zhaozheng.domain.TDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TDeptMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TDept record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TDept record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TDept selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TDept record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TDept record);

    List<TDept> findByAll(TDept tDept);


}