package com.entity;

/**
 * 客户端消息接收
 */
public class ReqMessage {
    private Long userId;//发送人
    private String userName;//发送人姓名
    private String msg;//发送信息
    private Long sendToId;//接收人
    private String sendToName;//接收人姓名

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getSendToId() {
        return sendToId;
    }

    public void setSendToId(Long sendToId) {
        this.sendToId = sendToId;
    }

    public String getSendToName() {
        return sendToName;
    }

    public void setSendToName(String sendToName) {
        this.sendToName = sendToName;
    }
}
