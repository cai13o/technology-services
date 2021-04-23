package com.zhaozheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@ServletComponentScan
@MapperScan({"com.zhaozheng.mapper"})
public class TechnologyServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechnologyServicesApplication.class, args);
    }

}
