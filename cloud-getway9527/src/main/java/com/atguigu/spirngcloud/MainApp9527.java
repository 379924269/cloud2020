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
public class MainApp9527 {
    public static void main(String[] args) {
        System.setProperty("csp.sentinel.app.type", "1");
        SpringApplication.run(MainApp9527.class, args);
    }
}
