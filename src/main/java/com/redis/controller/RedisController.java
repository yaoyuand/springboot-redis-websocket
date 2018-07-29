package com.redis.controller;

import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/redis")
    @ResponseBody
    public String redis(String channel,String message){
        this.redisService.chat(channel,message);
        return "消息发送成功!";
    }
    @RequestMapping("/show")
    public String show(){
        return "show";
    }
}
