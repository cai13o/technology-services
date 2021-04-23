package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TJobWanted")
@Data
public class TJobWanted implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 期望城市
    */
    @ApiModelProperty(value="期望城市")
    private String city;

    /**
    * 全职or兼职
    */
    @ApiModelProperty(value="全职or兼职")
    private String fullorpart;

    /**
    * 期望职位
    */
    @ApiModelProperty(value="期望职位")
    private String jobs;

    /**
    * 工资要求
    */
    @ApiModelProperty(value="工资要求")
    private String salary;

    /**
    * 允许认证企业查看我的联系方式
    */
    @ApiModelProperty(value="允许认证企业查看我的联系方式")
    private String status;

    @ApiModelProperty(value="")
    private String uid;

    private static final long serialVersionUID = 1L;
}