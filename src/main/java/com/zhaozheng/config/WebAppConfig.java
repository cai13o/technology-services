package com.zhaozheng.config;

import com.zhaozheng.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
  /*@Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
  }*/
  /*
    上面一个方法变成下面两个方法的目的是解决以下问题的：
    拦截器内使用@Autowired时出现了null，这是由于你的spring对象注入时机在你的拦截器之后了。
  */


  @Bean
  public AuthorizationInterceptor getAuthorizationInterceptor() {
    return new AuthorizationInterceptor();
  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getAuthorizationInterceptor())
        .addPathPatterns("/**")
            .excludePathPatterns("/swagger-ui.html")
            .excludePathPatterns("/swagger-ui/**")
            .excludePathPatterns("/configuration/ui")
            .excludePathPatterns("/swagger-resources")
            .excludePathPatterns("/swagger-resources/**")
            .excludePathPatterns("/configuration/security")
            .excludePathPatterns("/v3/api-docs")
            .excludePathPatterns("/error")
            .excludePathPatterns("/webjars/**");
  }
}
