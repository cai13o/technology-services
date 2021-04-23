package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-zhaozheng-domain-TCompany")
@Data
public class TCompany implements Serializable {
    @ApiModelProperty(value = "")
    private String id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String name;

    /**
     * 所属区域
     */
    @ApiModelProperty(value = "所属区域")
    private String area;

    /**
     * 企业性质
     */
    @ApiModelProperty(value = "企业性质")
    private String typeid;

    /**
     * 信用代码
     */
    @ApiModelProperty(value = "信用代码")
    private String creditCode;

    /**
     * 法人
     */
    @ApiModelProperty(value = "法人")
    private String corp;

    /**
     * 注册资本
     */
    @ApiModelProperty(value = "注册资本")
    private String registeredCapital;

    /**
     * 成立日期
     */
    @ApiModelProperty(value = "成立日期")
    private Date registerdate;

    /**
     * 有效期
     */
    @ApiModelProperty(value = "有效期")
    private String indate;

    /**
     * 注册地址
     */
    @ApiModelProperty(value = "注册地址")
    private String registeredAddress;

    /**
     * 经营范围
     */
    @ApiModelProperty(value = "经营范围")
    private String businessCope;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contact;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
     * 执照编号
     */
    @ApiModelProperty(value = "执照编号")
    private String licenseno;

    /**
     * 登记机关
     */
    @ApiModelProperty(value = "登记机关")
    private String registrationAuthority;

    /**
     * 备用电话
     */
    @ApiModelProperty(value = "备用电话")
    private String alternatePhone;

    /**
     * 办公地址
     */
    @ApiModelProperty(value = "办公地址")
    private String businessAddress;

    /**
     * 企业描述
     */
    @ApiModelProperty(value = "企业描述")
    private String desc;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String photo;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;

    private static final long serialVersionUID = 1L;
}