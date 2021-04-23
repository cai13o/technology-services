package com.zhaozheng.mapper;

import com.zhaozheng.domain.TJobWanted;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TJobWantedMapper {
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
    int insert(TJobWanted record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TJobWanted record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TJobWanted selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TJobWanted record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TJobWanted record);
}