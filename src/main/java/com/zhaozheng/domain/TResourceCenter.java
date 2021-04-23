package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TResourceCenter")
@Data
public class TResourceCenter implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 资料名称
    */
    @ApiModelProperty(value="资料名称")
    private String name;

    /**
    * url
    */
    @ApiModelProperty(value="url")
    private String url;

    /**
    * 大小
    */
    @ApiModelProperty(value="大小")
    private String size;

    /**
    * 操作时间
    */
    @ApiModelProperty(value="操作时间")
    private Date opdate;

    /**
    * 审核状态
    */
    @ApiModelProperty(value="审核状态")
    private String auditStatus;

    /**
    * 审核时间
    */
    @ApiModelProperty(value="审核时间")
    private Date auditdate;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private String operator;

    /**
    * 次数
    */
    @ApiModelProperty(value="次数")
    private Integer count;

    /**
    * 审核意见
    */
    @ApiModelProperty(value="审核意见")
    private String auditOpinion;

    /**
    * 审核人
    */
    @ApiModelProperty(value="审核人")
    private String auditor;

    /**
    * 是否公开
    */
    @ApiModelProperty(value="是否公开")
    private String disc;

    private static final long serialVersionUID = 1L;
}