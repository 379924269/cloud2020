package com.atguigu.spirngcloud.entities;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huazai
 * @description
 * @date 2022/7/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String msg;
    private T data;
}
