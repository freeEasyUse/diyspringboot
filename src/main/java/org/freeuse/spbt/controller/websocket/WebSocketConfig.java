package org.freeuse.spbt.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * websocket config
 * @author GeL
 *
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	
	/**
	 * 配置服务端
	 * @return
	 */
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
	
	
	/**
	 * 引入websocket服务
	 */
	@Autowired
	private MyTextWebSocketHandler myTextWebSocketHandler;
	
	/**
	 * 注册服务
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		WebSocketHandlerRegistration socketHandlerRegistration =  registry.addHandler(myTextWebSocketHandler, "/websockTest");
		//
		socketHandlerRegistration.addInterceptors(new HttpSessionHandshakeInterceptor());
		//允许服务段 socketjs
		//socketHandlerRegistration.withSockJS();
		socketHandlerRegistration.setAllowedOrigins("*");
	}

}
