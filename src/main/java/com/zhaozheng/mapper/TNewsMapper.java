package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.zhaozheng.domain.TNews;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TNewsMapper {
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
    int insert(TNews record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TNews record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TNews selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TNews record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TNews record);

    List<TNews> findByAll(TNews tNews);

}