package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TDept")
@Data
public class TDept implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 部门名称
    */
    @ApiModelProperty(value="部门名称")
    private String name;

    /**
    * 部门描述
    */
    @ApiModelProperty(value="部门描述")
    private String introduction;

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
    private String cid;

    private static final long serialVersionUID = 1L;
}