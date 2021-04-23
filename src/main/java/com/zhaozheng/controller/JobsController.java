package com.zhaozheng.controller;

import com.zhaozheng.domain.TJobs;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TJobsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "岗位管理")
@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Resource
    private TJobsService tJobsService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveJobs", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TJobs tJobs) {
        System.out.println(tJobs);
        if (this.tJobsService.insertSelective(tJobs) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/getJobs", method = RequestMethod.GET)
    public Result selectByPrimaryKey(String id) {
        TJobs tJobs = this.tJobsService.selectByPrimaryKey(id);
        return Result.ok(ResultCodeEnum.SUCCESS,tJobs);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upJobs", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TJobs tJobs) {
        if (this.tJobsService.updateByPrimaryKeySelective(tJobs) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id删除数据")
    @RequestMapping(value = "/delJobs", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tJobsService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
    public Object findByAll(TJobs tJobs) {
        List<TJobs> tCompanies = this.tJobsService.findByAll(tJobs);
        return Result.ok(ResultCodeEnum.SUCCESS,tCompanies);
    }
}
