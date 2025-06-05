package com.cinema.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//配置要扫描mapper的包
@MapperScan("com.cinema.**.mapper")
public class ApplicationConfiguration {
}
