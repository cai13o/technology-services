package com.zhaozheng.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.zhaozheng.annotation.IgnoreAuth;
import com.zhaozheng.exception.BusinessException;
import com.zhaozheng.utils.InterceptUtil;
import com.zhaozheng.utils.JwtUtil;
import com.zhaozheng.utils.StringUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 权限(Token)验证
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    public static final String USER_KEY = "LOGIN_USER_KEY";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getServletPath();
        // 支持跨域请求
//        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        // 如果有@IgnoreAuth注解，则不验证token
        if (annotation != null) {
            return true;
        }

        // 获取用户凭证
        String token = request.getHeader("Authorization");
        if (StringUtil.isBlank(token)) {
            token = request.getParameter(jwtUtil.getHeader());
        }

        // 凭证为空
        if (StringUtil.isBlank(token)) {
//            throw new BusinessException(jwtUtil.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
            Map<String, Object> object = new ConcurrentHashMap<>();
            object.put("msg", "请重新登录");
            String jsonObjectStr = JSONObject.toJSONString(object);
            InterceptUtil.returnJson(response, jsonObjectStr);
            return false;
        }

        Claims claims = jwtUtil.getClaimByToken(token);
        if (claims == null || jwtUtil.isTokenExpired(claims.getExpiration())) {
            throw new BusinessException(jwtUtil.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }

        // 设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, claims.getSubject());

        return true;
    }
}
