package com.atguigu.spirngcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Component
public class ProviderPaymentFallbackService implements ProviderPayment9001Service {
	@Override
	public String getPayment(Integer id) {
		return "限流错误";
	}
}
