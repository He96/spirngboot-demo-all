package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker//开启使用STOMP协议传输消息
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry registry) {//注册协议节点
        //注册一个STOMP的endpoint
        registry.addEndpoint("/endpointWisely").withSockJS();
        //注册一个私聊节点
        registry.addEndpoint("/endpointChat").withSockJS();
    }
    //配置消息代理
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式配置一个/topic消息代理
        //新增一个/queue消息代理
        registry.enableSimpleBroker("/queue","/topic");
    }
    //注册UserInterceptor
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new UserInterceptor());
    }
}
