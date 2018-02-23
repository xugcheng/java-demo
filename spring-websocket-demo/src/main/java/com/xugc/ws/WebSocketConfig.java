package com.xugc.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private MyTextWebSocketHandler myTextWebSocketHandler;

    @Autowired
    private MyHandshakeIntercepter myHandshakeIntercepter;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(myTextWebSocketHandler, "/ws")
                .addInterceptors(myHandshakeIntercepter)
                .setAllowedOrigins("*");
        registry.addHandler(myTextWebSocketHandler, "/sockjs")
                .addInterceptors(myHandshakeIntercepter)
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
