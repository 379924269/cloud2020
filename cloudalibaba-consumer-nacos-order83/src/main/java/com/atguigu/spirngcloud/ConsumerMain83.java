package com.atguigu.spirngcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huazai
 * @description
 * @date 2022/7/26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain83.class, args);

    }
}
