package com.example.demo.config;

/**
 * @author jinyin wang
 * @create 2020-04-09 15:31
 * 限流类型
 */
public enum LimitType {

    /**
     * 自定义key
     */
    CUSTOMER,

    /**
     * 请求者IP
     */
    IP;
}
