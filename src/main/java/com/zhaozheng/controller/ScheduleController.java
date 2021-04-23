package com.zhaozheng.controller;


import com.zhaozheng.domain.TSchedule;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.*;

@Api(tags = "日程事宜管理")
@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Resource
    private TScheduleService tScheduleService;

    @ApiOperation("新增数据")
    @RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
    public Result insertSelective(@RequestBody TSchedule tSchedule) {
        if (this.tScheduleService.insertSelective(tSchedule) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @RequestMapping(value = "/delSchedule", method = RequestMethod.DELETE)
    public Result deleteByPrimaryKey(String id) {
        if (this.tScheduleService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @RequestMapping(value = "/getSchedule", method = RequestMethod.GET)
    public Result selectByPrimaryKey(String id) {
        TSchedule tSchedule = this.tScheduleService.selectByPrimaryKey(id);
        if (null != tSchedule) {
            return Result.ok(ResultCodeEnum.SUCCESS, tSchedule);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/upSchedule", method = RequestMethod.PUT)
    public Result updateByPrimaryKeySelective(@RequestBody TSchedule tSchedule) {
        if (this.tScheduleService.updateByPrimaryKeySelective(tSchedule) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @RequestMapping(value = "/findByAllSchedule", method = RequestMethod.PUT)
    public Result findByAll(TSchedule tSchedule) {
        List<TSchedule> tSchedules = this.tScheduleService.findByAll(tSchedule);
        HashMap<String, Object> map = new HashMap<>();
        map.put("tSchedules",tSchedules);
        map.put("total", tSchedules.size());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }

}
