package com.entity;

/**
 * 发送消息给客户端
 */
public class ResMessage {
    private String sendUser;
    private String responseMessage;
    private String time;

    public ResMessage(String sendUser,String responseMessage,String time) {
        this.sendUser = sendUser;
        this.responseMessage = responseMessage;
        this.time = time;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
    public String getSendUser(){
        return sendUser;
    }

    public String getTime(){
        return time;
    }

}
