package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-zhaozheng-domain-TUser")
@Data
public class TUser implements Serializable {
    @ApiModelProperty(value = "")
    private String id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 曾用名
     */
    @ApiModelProperty(value = "曾用名")
    private String beforename;

    /**
     * 身份证
     */
    @ApiModelProperty(value = "身份证")
    private String idcard;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    private Date birthdate;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private String age;

    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "政治面貌")
    private String political;

    /**
     * 入团日期
     */
    @ApiModelProperty(value = "入团日期")
    private Date leaguetime;

    /**
     * 入党日期
     */
    @ApiModelProperty(value = "入党日期")
    private Date partytime;

    /**
     * 最高学历
     */
    @ApiModelProperty(value = "最高学历")
    private String education;

    /**
     * 最高学位
     */
    @ApiModelProperty(value = "最高学位")
    private String degree;

    /**
     * 婚姻状况
     */
    @ApiModelProperty(value = "婚姻状况")
    private String marriage;

    /**
     * 健康状况
     */
    @ApiModelProperty(value = "健康状况")
    private String healthy;

    /**
     * 身高(厘米)
     */
    @ApiModelProperty(value = "身高(厘米)")
    private String stature;

    /**
     * 体重(千克)
     */
    @ApiModelProperty(value = "体重(千克)")
    private String weight;

    /**
     * 现居地
     */
    @ApiModelProperty(value = "现居地")
    private String presentAddress;

    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String natives;

    /**
     * 出生地
     */
    @ApiModelProperty(value = "出生地")
    private String birthplace;

    /**
     * 户口性质
     */
    @ApiModelProperty(value = "户口性质")
    private String householdType;

    /**
     * 户口所在地
     */
    @ApiModelProperty(value = "户口所在地")
    private String householdAddress;

    /**
     * 户口所在派出所
     */
    @ApiModelProperty(value = "户口所在派出所")
    private String householdPolice;

    /**
     * 到本单位日期
     */
    @ApiModelProperty(value = "到本单位日期")
    private Date reporttime;

    /**
     * 参加工作日期
     */
    @ApiModelProperty(value = "参加工作日期")
    private Date jobtime;

    /**
     * 工龄
     */
    @ApiModelProperty(value = "工龄")
    private String seniority;

    /**
     * 本企业工龄
     */
    @ApiModelProperty(value = "本企业工龄")
    private String firmSeniority;

    /**
     * 附件（简历）
     */
    @ApiModelProperty(value = "附件（简历）")
    private String accessory;

    /**
     * 操作日期
     */
    @ApiModelProperty(value = "操作日期")
    private Date opdate;

    /**
     * 操作表示
     */
    @ApiModelProperty(value = "操作表示")
    private String opflag;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 锁定状态
     */
    @ApiModelProperty(value = "锁定状态")
    private String state;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String operator;

    /**
     * 激活时间
     */
    @ApiModelProperty(value = "激活时间")
    private Date startdate;

    /**
     * 失效时间
     */
    @ApiModelProperty(value = "失效时间")
    private Date enddate;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String img;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "")
    private String cid;

    @ApiModelProperty(value = "")
    private String did;

    @ApiModelProperty(value = "")
    private String jid;

    private static final long serialVersionUID = 1L;
}