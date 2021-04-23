package com.zhaozheng.api;



import com.zhaozheng.annotation.IgnoreAuth;
import com.zhaozheng.domain.TUser;
import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.result.Result;
import com.zhaozheng.utils.JwtUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.google.common.collect.Maps.newHashMap;


// 用户信息
@RestController
@RequestMapping("app/")
@Slf4j
public class UserController {
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

    Map<String, Object> map = new HashMap<>(3);
    map.put("token", token);
    map.put("user", user);
    map.put("expire", jwtUtil.getExpire());
    return Result.okApp(ResultCodeEnum.SUCCESS,map);
  }

  // @IgnoreAuth
  @GetMapping("getUserInfo")
  public Result getUserInfo() throws Exception {
    return Result.okApp(ResultCodeEnum.SUCCESS,"123");
  }
}

