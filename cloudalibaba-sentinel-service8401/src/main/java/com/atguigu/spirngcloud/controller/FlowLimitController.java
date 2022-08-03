package com.atguigu.spirngcloud.controller;

import com.alibaba.cloud.sentinel.custom.SentinelAutoConfiguration;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.spirngcloud.service.ProviderPayment9001Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@RestController
@Slf4j
public class FlowLimitController {
	@GetMapping("/testA")
	public String testA() {
		return "------testA";
	}

	@GetMapping("/testB")
	public String testB() {
		return "------testB";
	}

	@GetMapping("/testD")
	public String testD() {
		SentinelAutoConfiguration configuration;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("testD 测试RT");
		return "------testD";
	}

	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
							 @RequestParam(value = "p2", required = false) String p2) {
		//int age = 10/0;
		return "------testHotKey";
	}

	@Resource
	private ProviderPayment9001Service providerPayment9001Service;
	@GetMapping("/testPayment")
	public Object testPayment() {
		log.info("==============我写的日志");
		final int i = 1 / 0;
		return providerPayment9001Service.getPayment(1);
	}

	/**
	 * 兜底方法
	 */
	public String deal_testHotKey(String p1, String p2, BlockException exception) {
		return "------deal_testHotKey,o(╥﹏╥)o";
	}
}

