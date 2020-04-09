package com.example.demo.service.impl;

import com.example.demo.service.TsetLuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author jinyin wang
 * @create 2020-04-09 17:39
 */
@Service
public class TestLuaServiceImpl implements TsetLuaService {

    @Autowired
    private RedisTemplate redisTemplate;

    /** 释放锁lua脚本 */
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";


    @Override
    public Object exectLua() {

        String lockKey = "123";
        String id = java.util.UUID.randomUUID().toString();

        boolean success = redisTemplate.opsForValue().setIfAbsent(lockKey,id,3, TimeUnit.MINUTES);
        if (!success){
            System.out.println("锁已存在");
        }

        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey),id);
        System.out.println(result);
        return result;
    }
}
