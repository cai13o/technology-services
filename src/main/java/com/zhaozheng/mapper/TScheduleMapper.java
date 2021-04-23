package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.zhaozheng.domain.TSchedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TScheduleMapper {
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
    int insert(TSchedule record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TSchedule record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TSchedule selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TSchedule record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TSchedule record);
    List<TSchedule> findByAll(TSchedule tSchedule);


}