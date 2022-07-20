package com.atguigu.spirngcloud.controller;

import com.atguigu.spirngcloud.entities.CommonResult;
import com.atguigu.spirngcloud.entities.Payment;
import com.atguigu.spirngcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sound.sampled.Port;
import javax.websocket.server.PathParam;

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
}
