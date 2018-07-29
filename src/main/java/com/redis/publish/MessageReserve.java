package com.redis.publish;

import com.redis.config.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReserve {
    @Autowired
    private WebSocket webSocket;
    public void message(String message){
        webSocket.sendAll(message);
    }
}
