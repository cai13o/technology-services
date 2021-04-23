package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TSystemAccount")
@Data
public class TSystemAccount implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 用户姓名
    */
    @ApiModelProperty(value="用户姓名")
    private String addressname;

    /**
    * 登录账号
    */
    @ApiModelProperty(value="登录账号")
    private String loginid;

    /**
    * 登录密码
    */
    @ApiModelProperty(value="登录密码")
    private String password;

    /**
    * 手机号
    */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
    * 用户角色
    */
    @ApiModelProperty(value="用户角色")
    private String role;

    /**
    * 用户描述
    */
    @ApiModelProperty(value="账号描述")
    private String desc;

    /**
    * 锁定状态
    */
    @ApiModelProperty(value="锁定状态")
    private String status;

    private static final long serialVersionUID = 1L;
}