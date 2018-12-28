package j2ee.demo.configuration;

import j2ee.demo.handler.WebSocketCustomizedHandler;
import j2ee.demo.handler.WebSocketCustomizedInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

/**
 * This way is Optional:
 * @EnableWebSocket 注解用于开启websocket
 * @see WebSocketConstant 查看使用方法
 * @author yansong
 */
@Configuration
@EnableWebSocket
public class WebSocketCustomizedConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketCustomizedHandler(), "/customizedConnectPath")
                .addInterceptors(new WebSocketCustomizedInterceptor())
                .setAllowedOrigins("*");
    }
}