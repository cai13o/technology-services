package com.zhaozheng.mapper;
import org.apache.ibatis.annotations.Param;

import com.zhaozheng.domain.TCompany;
import com.zhaozheng.domain.TSystemAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TSystemAccountMapper {
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
    int insert(TSystemAccount record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TSystemAccount record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TSystemAccount selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TSystemAccount record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TSystemAccount record);

    /**
     * select *
     *
     * @param tSystemAccount 对象
     * @return 数组对象
     */
    List<TSystemAccount> findByAll(TSystemAccount tSystemAccount);

    /**
     * update Password By Id
     *
     * @param id 对象
     * @return update count
     */
    int updatePasswordById(@Param("updatedPassword")String updatedPassword,@Param("id")String id);

    /**
     * update Password By Id
     *
     * @param id 对象
     * @return update count
     */
    int updateStatusById(@Param("updatedStatus")String updatedStatus,@Param("id")String id);

}