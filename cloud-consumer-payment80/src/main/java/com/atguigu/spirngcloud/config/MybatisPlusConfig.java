package com.atguigu.spirngcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"com.atguigu.spirngcloud.dao*"})
public class MybatisPlusConfig {

}
