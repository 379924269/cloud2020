package com.atguigu.spirngcloud.controller;

import com.atguigu.spirngcloud.entities.CommonResult;
import com.atguigu.spirngcloud.entities.Payment;
import com.atguigu.spirngcloud.service.PaymentService;
import com.sun.xml.internal.fastinfoset.util.ValueArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author huazai
 * @description
 * @date 2022/7/20
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/add")
    public CommonResult add(String serial) {
        final int result = paymentService.create(serial);
        return new CommonResult(200, "成功 :" + port, result);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id) {
        final Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200, "成功 :" + port, payment);
    }

    @GetMapping("/payment/getService")
    public Object getService() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> allList = new ArrayList<>();
        for (String service : services) {
            log.info("service : {}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            allList.addAll(instances);
        }
        return allList;
    }
}
