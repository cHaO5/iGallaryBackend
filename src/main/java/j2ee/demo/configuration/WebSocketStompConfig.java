package j2ee.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @EnableWebSocketMessageBroker 注解用于开启使用STOMP协议来传输基于代理（MessageBroker）的消息
 * @see WebSocketConstant 查看使用方法
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //服务端发送消息给客户端的域,多个用逗号隔开
        registry.enableSimpleBroker(WebSocketConstant.BROADCAST_BASE_PATH, WebSocketConstant.P2P_PUSH_PERFIX);
        //定义一对一推送的时候前缀
        registry.setUserDestinationPrefix(WebSocketConstant.P2P_PUSH_PERFIX);
        //定义websoket前缀
        registry.setApplicationDestinationPrefixes(WebSocketConstant.DESTINATION_PERFIX);
    }

    // use STOMP protocol, the sub-protocol of websocket, Must use stomp and sockjs to connect
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
        registry.addEndpoint(WebSocketConstant.CONNECT_PATH)
                // cors the origin
                .setAllowedOrigins("*")
                // choose the socket connection method sockJS
                .withSockJS();
    }

}