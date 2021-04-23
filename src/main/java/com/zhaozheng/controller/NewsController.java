package com.zhaozheng.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaozheng.domain.TNews;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Api(tags = "新闻管理")
@RestController
@RequestMapping("news")
public class NewsController {

    @Resource
    private TNewsService tNewsService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveNews", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TNews tNews) {
        if (this.tNewsService.insertSelective(tNews) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @RequestMapping(value = "/delNews", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tNewsService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/getNews", method = RequestMethod.GET)
    public Object selectByPrimaryKey(String id) {
        TNews tNews = this.tNewsService.selectByPrimaryKey(id);
        return Result.ok(ResultCodeEnum.SUCCESS,tNews);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upNews", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TNews tNews) {
        if (this.tNewsService.updateByPrimaryKeySelective(tNews) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAllNews", method = RequestMethod.GET)
    public Object findByAll(String page, String limit, TNews tNews) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TNews> tNewsList = this.tNewsService.findByAll(tNews);
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("tNews", tNews);
        map.put("total", new PageInfo(tNewsList, intLimit).getTotal());
        return Result.ok(ResultCodeEnum.SUCCESS,map);
    }

}
