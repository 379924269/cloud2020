package com.atguigu.spirngcloud.controller;

import com.atguigu.spirngcloud.entities.CommonResult;
import com.atguigu.spirngcloud.entities.Payment;
import com.atguigu.spirngcloud.service.PaymentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.net.URL;

/**
 * @author huazai
 * @description
 * @date 2022/7/20
 */
@RestController
public class PaymentController {
    @Resource
    private RestTemplate restTemplate;
    private static final String PROVIDER_URL = "http://localhost:8001";

    @PostMapping("/payment/add")
    public CommonResult add(String serial) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("serial", serial);
        final ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PROVIDER_URL + "/payment/add", map, CommonResult.class);
        return new CommonResult(200, "成功", commonResultResponseEntity.getBody().getData());
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id) {
        final ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.getForEntity(PROVIDER_URL + "/payment/get/"+ id, CommonResult.class);
        return new CommonResult(200, "成功", commonResultResponseEntity.getBody().getData());
    }
}
