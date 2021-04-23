package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TRecruitment")
@Data
public class TRecruitment implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 地址
    */
    @ApiModelProperty(value="地址")
    private String address;

    /**
    * 工作经验
    */
    @ApiModelProperty(value="工作经验")
    private String experience;

    /**
    * 学历
    */
    @ApiModelProperty(value="学历")
    private String education;

    /**
    * 最低薪资
    */
    @ApiModelProperty(value="最低薪资")
    private String minimumWage;

    /**
    * 最高薪资
    */
    @ApiModelProperty(value="最高薪资")
    private String maximumWage;

    /**
    * 标签
    */
    @ApiModelProperty(value="标签")
    private String tag;

    /**
    * 职位描述
    */
    @ApiModelProperty(value="职位描述")
    private String desc;

    /**
    * 联系人
    */
    @ApiModelProperty(value="联系人")
    private String contacts;

    /**
    * 联系电话
    */
    @ApiModelProperty(value="联系电话")
    private String phone;

    @ApiModelProperty(value="")
    private String cid;

    private static final long serialVersionUID = 1L;
}