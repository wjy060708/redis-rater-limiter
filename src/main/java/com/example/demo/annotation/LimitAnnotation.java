package com.example.demo.annotation;

import com.example.demo.config.LimitType;

import java.lang.annotation.*;

/**
 * @author jinyin wang
 * @create 2020-04-09 15:40
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //表示标注在的类型 方法
@Retention(RetentionPolicy.RUNTIME) //编译器将Annotation存储于class文件中，并且可由JVM读入
@Inherited
@Documented //@Documented 修饰该 Annotation，则表示它可以出现在 javadoc 中。
public @interface LimitAnnotation {

    /**
     * 名字
     * @return
     */
    String name() default "" ;

    /**
     * key
     * @return
     */
    String key() default  "";

    /**
     * key的前缀
     * @return
     */
    String prefix() default "";

    /**
     * 给定的时间范围 单位(秒)
     * @return
     */
    int period();

    /**
     * 一定时间内最多访问次数
     * @return
     */
    int count();

    /**
     * 限流的类型(用户自定义key 或者 请求ip)
     * @return
     */
    LimitType limitType() default LimitType.CUSTOMER;


}
