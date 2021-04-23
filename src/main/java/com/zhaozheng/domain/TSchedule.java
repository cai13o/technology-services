package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TSchedule")
@Data
public class TSchedule implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private String id;

    /**
    * 上下文
    */
    @ApiModelProperty(value="上下文")
    private String context;

    /**
    * 日期
    */
    @ApiModelProperty(value="日期")
    private Date time;

    /**
    * 开始时间
    */
    @ApiModelProperty(value="开始时间")
    private Date startdate;

    /**
    * 结束时间
    */
    @ApiModelProperty(value="结束时间")
    private Date enddate;

    /**
    * 所有者
    */
    @ApiModelProperty(value="所有者")
    private String owner;

    /**
    * 重复类型
    */
    @ApiModelProperty(value="重复类型")
    private String repeatTypes;

    /**
    * 提醒设置
    */
    @ApiModelProperty(value="提醒设置")
    private String remindSet;

    /**
    * 关联URL
    */
    @ApiModelProperty(value="关联URL")
    private String associatedUrl;

    /**
    * 地点
    */
    @ApiModelProperty(value="地点")
    private String site;

    /**
    * 活动性质
    */
    @ApiModelProperty(value="活动性质")
    private String activities;

    /**
    * 可阅读者
    */
    @ApiModelProperty(value="可阅读者")
    private String reader;

    /**
    * 可编辑者
    */
    @ApiModelProperty(value="可编辑者")
    private String editors;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String content;

    /**
    * 附件
    */
    @ApiModelProperty(value="附件")
    private String accessory;

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
    private String status;

    /**
    * eid
    */
    @ApiModelProperty(value="eid")
    private String eid;

    private static final long serialVersionUID = 1L;
}