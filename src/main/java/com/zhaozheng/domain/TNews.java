package com.zhaozheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-zhaozheng-domain-TNews")
@Data
public class TNews implements Serializable {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 新闻类型
    */
    @ApiModelProperty(value="新闻类型")
    private String type;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 作者
    */
    @ApiModelProperty(value="作者")
    private String author;

    /**
    * 有效期
    */
    @ApiModelProperty(value="有效期")
    private Date validite;

    /**
    * 发布日期
    */
    @ApiModelProperty(value="发布日期")
    private Date issuedate;

    /**
    * 内容简要
    */
    @ApiModelProperty(value="内容简要")
    private String brief;

    /**
    * 文本
    */
    @ApiModelProperty(value="文本")
    private String text;

    /**
    * 文档
    */
    @ApiModelProperty(value="文档")
    private String file;

    /**
    * 标题图片
    */
    @ApiModelProperty(value="标题图片")
    private String titlepicfile;

    /**
    * 审核状态
    */
    @ApiModelProperty(value="审核状态")
    private String auditStatus;

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
    * 审核时间
    */
    @ApiModelProperty(value="审核时间")
    private Date auditdate;

    /**
    * 重要度
    */
    @ApiModelProperty(value="重要度")
    private String importance;

    /**
    * 新闻来源
    */
    @ApiModelProperty(value="新闻来源")
    private String newsSource;

    /**
    * 是否公开
    */
    @ApiModelProperty(value="是否公开")
    private String disc;

    /**
    * 标签
    */
    @ApiModelProperty(value="标签")
    private String tag;

    /**
    * 是否置顶
    */
    @ApiModelProperty(value="是否置顶")
    private String top;

    /**
    * 点击数
    */
    @ApiModelProperty(value="点击数")
    private Integer ctr;

    private static final long serialVersionUID = 1L;
}