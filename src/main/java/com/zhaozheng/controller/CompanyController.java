package com.zhaozheng.controller;

import com.zhaozheng.domain.TCompany;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "公司管理")
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private TCompanyService tCompanyService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TCompany tCompany) {
        System.out.println(tCompany);
        if (this.tCompanyService.insertSelective(tCompany) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    public Result selectByPrimaryKey(String id) {
        TCompany tCompany = this.tCompanyService.selectByPrimaryKey(id);
        return Result.ok(ResultCodeEnum.SUCCESS,tCompany);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upCompany", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TCompany tCompany) {
        if (this.tCompanyService.updateByPrimaryKeySelective(tCompany) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id删除数据")
    @RequestMapping(value = "/delCompany", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tCompanyService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/getAllCompany", method = RequestMethod.GET)
    public Object findByAll(TCompany tCompany) {
        List<TCompany> tCompanies = this.tCompanyService.findByAll(tCompany);
        return Result.ok(ResultCodeEnum.SUCCESS,tCompanies);
    }
}
