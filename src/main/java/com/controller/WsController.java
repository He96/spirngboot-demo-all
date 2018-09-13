package com.controller;

import com.alibaba.fastjson.JSON;
import com.config.LoginContext;
import com.config.LoginInfo;
import com.entity.ReqMessage;
import com.entity.ResMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 聊天接口
 */
@Controller
public class WsController {
    //通过此类向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private LoginContext loginContext;

    //群聊模式
    @MessageMapping("/sendAll")
    @SendTo("/topic/getResponse")
    public ResMessage say(ReqMessage message) throws Exception {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return new ResMessage(message.getUserName(), message.getMsg(), time);
    }

    //私聊模式
    @MessageMapping("/chat")
    public void handleChat(ReqMessage req) throws Exception {
        //LoginInfo info = loginContext.getInfo();
        messagingTemplate.convertAndSendToUser(req.getSendToId().toString(),
                "/queue/notifications", JSON.toJSON(req));
    }

}
