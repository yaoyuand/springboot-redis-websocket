package com.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void chat(String channel,String message){
        redisTemplate.convertAndSend(channel,message);
    }
}
