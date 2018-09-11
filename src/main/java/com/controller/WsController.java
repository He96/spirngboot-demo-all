package com.controller;

import com.entity.ReqMessage;
import com.entity.ResMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResMessage say(ReqMessage message) throws Exception {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return new ResMessage(message.getUserName(),message.getMsg(),time);
    }

}
