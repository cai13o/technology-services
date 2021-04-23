package com.zhaozheng.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhaozheng.annotation.IgnoreAuth;
import com.zhaozheng.domain.TSystemAccount;
import com.zhaozheng.domain.TUser;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.service.TSystemAccountService;
import com.zhaozheng.utils.JwtUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

import static com.google.common.collect.Maps.newHashMap;



@Api(tags = "登录")
@RestController
@Slf4j
public class LoginController {
  @Autowired
  private JwtUtil jwtUtil;

  @Resource
  private TSystemAccountService tSystemAccountService;


  @IgnoreAuth
  @PostMapping("login")
  @ApiOperation(value = "后台系统账号登录", notes = "根据账号密码登录")
  public Result login(@RequestBody TSystemAccount systemAccount) {
    String loginid = systemAccount.getLoginid();
    log.info(loginid, "帐号不能为空");
    String password = systemAccount.getPassword();
    log.info(password, "密码不能为空");
    String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
    systemAccount.setPassword(md5Password);

    TSystemAccount tSystemAccount = this.tSystemAccountService.findByAll(systemAccount).get(0);

    Map<String, Object> map = new HashMap<>(3);
    if (tSystemAccount == null) {
      map.put("message", "用户名或密码错误");
      return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
//    } else if (!tSystemAccount.getUsername().equals("admin")) {
//      TPermission tPermission = tPermissionService.selectByPrimaryKey(tEmp.getJobs());
//      if (systemAccount.getStatus() == "0") {
//        map.put("message", "账号未激活");
//        return map;
//      } else if (tEmp.getStartdate().getTime() > new Date().getTime()) {
//        map.put("message", "账号未生效");
//        return map;
//      } else if (tEmp.getEnddate().getTime() < new Date().getTime()) {
//        map.put("message", "账号已失效");
//        return map;
//      } else if (tPermission.getRoute() == null || tPermission.getRoute().equals("")) {
//        map.put("message", "账号未分配权限");
//        return map;
//      }
    }

    String token = jwtUtil.generateToken(systemAccount.getLoginid());


    map.put("token", token);
    map.put("systemAccount", systemAccount);
    map.put("expire", jwtUtil.getExpire());
    return Result.ok(ResultCodeEnum.SUCCESS,map);
  }

  // @IgnoreAuth
  @GetMapping("getUserInfo")
  public Result getUserInfo() {
    return Result.ok(ResultCodeEnum.SUCCESS,"123");
  }
}

