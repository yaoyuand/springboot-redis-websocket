package com.redis.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket")
public class WebSocket {
    private Session session;
    private static CopyOnWriteArraySet<WebSocket> set=new CopyOnWriteArraySet<>();
    //创建链接
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        set.add(this);
    }
    @OnClose
    public void onCloae(){
        set.remove(this);
    }
    @OnMessage
    public void onMessage(String message){
        System.out.println("接收到客户端发送消息为:"+message);
    }
    public void sendAll(String message){
        try {
            for(WebSocket webSocket:set){
                webSocket.session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            System.out.println("发送消息出错:"+e.getMessage());
        }
    }
}
