package com.snails.redis.service.impl;

import com.snails.redis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void hello() {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("name","马儿扎哈");
        String name = opsForValue.get("name");
        System.out.println(name);
    }
}
