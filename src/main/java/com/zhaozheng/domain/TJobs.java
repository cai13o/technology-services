package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TJobs")
@Data
public class TJobs implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 岗位名称
    */
    @ApiModelProperty(value="岗位名称")
    private String name;

    /**
    * 岗位描述
    */
    @ApiModelProperty(value="岗位描述")
    private String introduction;

    @ApiModelProperty(value="")
    private Integer cid;

    /**
    * 操作状态
    */
    @ApiModelProperty(value="操作状态")
    private String opflag;

    /**
    * 操作时间
    */
    @ApiModelProperty(value="操作时间")
    private Date opdate;

    @ApiModelProperty(value="")
    private String did;

    private static final long serialVersionUID = 1L;
}