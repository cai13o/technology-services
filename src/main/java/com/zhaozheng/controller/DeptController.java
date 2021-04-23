package com.zhaozheng.controller;

import com.zhaozheng.domain.TDept;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "部门管理")
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Resource
    private TDeptService tDeptService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveDept", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TDept tDept) {
        System.out.println(tDept);
        if (this.tDeptService.insertSelective(tDept) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/getDept", method = RequestMethod.GET)
    public Result selectByPrimaryKey(String id) {
        TDept tDept = this.tDeptService.selectByPrimaryKey(id);
        return Result.ok(ResultCodeEnum.SUCCESS,tDept);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upDept", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TDept tDept) {
        if (this.tDeptService.updateByPrimaryKeySelective(tDept) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id删除数据")
    @RequestMapping(value = "/delDept", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tDeptService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/getAllDept", method = RequestMethod.GET)
    public Object findByAll(TDept tDept) {
        List<TDept> tCompanies = this.tDeptService.findByAll(tDept);
        return Result.ok(ResultCodeEnum.SUCCESS,tCompanies);
    }
}
