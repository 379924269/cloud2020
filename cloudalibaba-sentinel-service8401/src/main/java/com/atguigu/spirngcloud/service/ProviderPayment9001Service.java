package com.atguigu.spirngcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description
 * @Author huazai
 * @Date 2022/8/3 8:51
 */
@FeignClient(value = "nacos-payment-provider", fallback = ProviderPaymentFallbackService.class)
public interface ProviderPayment9001Service {
    @GetMapping(value = "/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);
}
