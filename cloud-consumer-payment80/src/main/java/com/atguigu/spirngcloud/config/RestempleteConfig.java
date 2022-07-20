package com.atguigu.spirngcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author huazai
 * @description
 * @date 2022/7/20
 */
@Component
public class RestempleteConfig {
    @Bean
    public RestTemplate getTemplete() {
        return new RestTemplate();
    }
}
