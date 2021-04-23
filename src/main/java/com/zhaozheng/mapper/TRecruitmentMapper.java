package com.zhaozheng.mapper;

import com.zhaozheng.domain.TRecruitment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TRecruitmentMapper {
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
    int insert(TRecruitment record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TRecruitment record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TRecruitment selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TRecruitment record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TRecruitment record);
}