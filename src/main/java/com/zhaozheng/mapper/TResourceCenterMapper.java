package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.zhaozheng.domain.TResourceCenter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TResourceCenterMapper {
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
    int insert(TResourceCenter record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TResourceCenter record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TResourceCenter selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TResourceCenter record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TResourceCenter record);
    List<TResourceCenter> findByAll(TResourceCenter tResourceCenter);


}