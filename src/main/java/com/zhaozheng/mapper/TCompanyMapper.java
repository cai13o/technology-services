package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.zhaozheng.domain.TCompany;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TCompanyMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(TCompany record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(TCompany record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    TCompany selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TCompany record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TCompany record);

    /**
     * select *
     *
     * @param tCompany 对象
     * @return 数组对象
     */
    List<TCompany> findByAll(TCompany tCompany);

}