package com.atguigu.spirngcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerPayment80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerPayment80.class, args);
    }
}
