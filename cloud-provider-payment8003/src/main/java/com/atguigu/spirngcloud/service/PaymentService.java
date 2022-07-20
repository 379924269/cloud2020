package com.atguigu.spirngcloud.service;

import com.atguigu.spirngcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description
 * @Author huazai
 * @Date 2022/7/20 9:20
 */
public interface PaymentService {
    int create(@Param("serial") String serial);

    Payment getPaymentById(@Param("id") Integer id);
}
