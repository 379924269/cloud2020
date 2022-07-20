package com.atguigu.spirngcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderPayment8003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8003.class, args);
    }
}
