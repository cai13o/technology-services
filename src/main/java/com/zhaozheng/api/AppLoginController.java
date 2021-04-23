package com.zhaozheng.api;



import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import com.zhaozheng.annotation.IgnoreAuth;
import com.zhaozheng.domain.TUser;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.utils.JwtUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.google.common.collect.Maps.newHashMap;


// 用户信息
@Api(tags = "app/登录")
@RestController
@RequestMapping("app/")
@Slf4j
public class AppLoginController {
  @Autowired
  private JwtUtil jwtUtil;


  @IgnoreAuth
  @PostMapping("login")
  @ApiOperation(value = "手机号密码登录", notes = "根据手机号密码登录")
  @ApiImplicitParams({
          @ApiImplicitParam(paramType = "body", name = "jsonObject", value = "JSON格式参数", examples = @Example({
                  @ExampleProperty(mediaType = "mobile", value = "13679212824"),
                  @ExampleProperty(mediaType = "password", value = "admin")
          }), required = true, dataType = "string")
  })
  public Result loginByMobile(@RequestBody TUser user) throws Exception {
    String mobile = user.getUsername();
    log.info(mobile, "手机号不能为空");

    String password = user.getPassword();
    log.info(password, "密码不能为空");
    // 用户登录
    //UserEntity user = null; // userService.loginByMobile(mobile, password);
    //user = new UserEntity(mobile, password);
    // 生成token
    // String token = jwtUtil.generateToken(user.getId());
    String token = jwtUtil.generateToken(user.getUsername());
    String Str = HexBin.encode(token.getBytes("utf-8"));

    Map<String, Object> map = new HashMap<>(3);
    map.put("token", Str);
    map.put("user", user);
    map.put("expire", jwtUtil.getExpire());
    return Result.okApp(ResultCodeEnum.SUCCESS,map);
  }

  @IgnoreAuth
  @PostMapping("verification")
  @ApiOperation(value = "获取验证码", notes = "根据手机号获取")
  public Result loginByVerification(String username) throws Exception {
    String token = jwtUtil.generateToken(username);
    String Str = HexBin.encode(token.getBytes("utf-8"));
    Map<String, Object> map = new HashMap<>(2);
    map.put("token", Str);
    map.put("expire", jwtUtil.getExpire());
    return Result.okApp(ResultCodeEnum.SUCCESS,map);
  }

  // @IgnoreAuth
  @GetMapping("getUserInfo")
  public Result getUserInfo() throws Exception {
    return Result.okApp(ResultCodeEnum.SUCCESS,"123");
  }
}

