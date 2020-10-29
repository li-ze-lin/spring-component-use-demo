package cn.lzl.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 配置WebSocket
 */
@Configuration
//开启STOMP协议
@EnableWebSocketMessageBroker
public class MyWebSocket implements WebSocketMessageBrokerConfigurer {

    @Override
    //注册STOMP协议节点 映射的url
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //广播 指定使用SockJS协议
        stompEndpointRegistry
                .addEndpoint("/broadcast")
                .setAllowedOrigins("*")//跨域
                .withSockJS();//使用SockJS
    }

    @Override
    //配置消息代理
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
