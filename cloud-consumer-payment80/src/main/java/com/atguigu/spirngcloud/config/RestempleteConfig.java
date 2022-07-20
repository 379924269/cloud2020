package com.atguigu.spirngcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    // TODO  注意加  @LoadBalanced 实现负载均衡
    @Bean
    @LoadBalanced
    public RestTemplate getTemplete() {
        return new RestTemplate();
    }
}
