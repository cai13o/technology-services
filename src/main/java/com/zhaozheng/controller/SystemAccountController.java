package com.zhaozheng.controller;

import com.zhaozheng.domain.TSystemAccount;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TSystemAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "系统账号")
@RestController
@RequestMapping("/systemAccount")
public class SystemAccountController {
    
    @Resource
    private TSystemAccountService tSystemAccountService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveSystemAccount", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TSystemAccount tSystemAccount) {
        System.out.println(tSystemAccount);
        if (this.tSystemAccountService.insertSelective(tSystemAccount) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upSystemAccount", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TSystemAccount tSystemAccount) {
        if (this.tSystemAccountService.updateByPrimaryKeySelective(tSystemAccount) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id删除数据")
    @RequestMapping(value = "/delSystemAccount", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tSystemAccountService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/getAllSystemAccount", method = RequestMethod.GET)
    public Object findByAll(TSystemAccount tSystemAccount) {
        List<TSystemAccount> tCompanies = this.tSystemAccountService.findByAll(tSystemAccount);
        return Result.ok(ResultCodeEnum.SUCCESS,tCompanies);
    }

    @ApiOperation("重置密码")
    @RequestMapping(value = "/resetPasswords", method = RequestMethod.PUT)
    public Result updateByPassword(String id) {
        if (this.tSystemAccountService.updateByPassword(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("锁定状态")
    @RequestMapping(value = "/lockingState", method = RequestMethod.PUT)
    public Result updateByStatus(String id,String status) {
        if (this.tSystemAccountService.updateByStatus(id,status) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }
}
