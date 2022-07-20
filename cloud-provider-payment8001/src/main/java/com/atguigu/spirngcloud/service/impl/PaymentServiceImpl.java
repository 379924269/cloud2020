package com.atguigu.spirngcloud.service.impl;

import com.atguigu.spirngcloud.dao.PaymentDao;
import com.atguigu.spirngcloud.entities.Payment;
import com.atguigu.spirngcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huazai
 * @description
 * @date 2022/7/20
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(String serial) {
        return paymentDao.create(serial);

    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
