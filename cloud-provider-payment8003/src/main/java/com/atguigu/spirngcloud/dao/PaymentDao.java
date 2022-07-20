package com.atguigu.spirngcloud.dao;

import com.atguigu.spirngcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description
 * @Author huazai
 * @Date 2022/7/20 9:20
 */
public interface PaymentDao {
    int create(@Param("serial") String serial);

    Payment getPaymentById(@Param("id") Integer id);
}
