package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.zhaozheng.domain.TJobs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TJobsMapper<findByAll> {
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
    int insert(TJobs record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TJobs record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TJobs selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TJobs record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TJobs record);

    List<TJobs> findByAll(TJobs tJobs);


}