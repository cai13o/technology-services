package com.zhaozheng.controller;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaozheng.domain.TResourceCenter;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TResourceCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

@Api(tags = "资料中心管理")
@RestController
@RequestMapping("resource")
public class ResourceController {

    @Resource
    private TResourceCenterService tResourceCenterService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveResource", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TResourceCenter tResourceCenter) {
        if (this.tResourceCenterService.insertSelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @RequestMapping(value = "/delResource", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tResourceCenterService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/getResource", method = RequestMethod.GET)
    public Result selectByPrimaryKey(String id) {
        TResourceCenter tResourceCenter = this.tResourceCenterService.selectByPrimaryKey(id);
        if (null != tResourceCenter) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("suffix", tResourceCenter.getUrl().substring(tResourceCenter.getUrl().lastIndexOf(".")));
            map.put("tResourceCenter",tResourceCenter);
            return Result.ok(ResultCodeEnum.SUCCESS, map);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upResource", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TResourceCenter tResourceCenter) {
        if (this.tResourceCenterService.updateByPrimaryKeySelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAllResource", method = RequestMethod.GET)
    public Result findByAll(String page, String limit, TResourceCenter tResourceCenter) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TResourceCenter> tResourceCenters = this.tResourceCenterService.findByAll(tResourceCenter);
        Map<String, Object> map = new HashMap<>();
        map.put("tResourceCenters",tResourceCenters);
        map.put("total", new PageInfo(tResourceCenters, intLimit).getTotal());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }

    @ApiOperation("阅读量")
    @GetMapping("count")
    public Result count(String id) {
        TResourceCenter tResourceCenter = this.tResourceCenterService.selectByPrimaryKey(id);
        tResourceCenter.setCount(tResourceCenter.getCount()+1);
        if (this.tResourceCenterService.updateByPrimaryKeySelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }
}
