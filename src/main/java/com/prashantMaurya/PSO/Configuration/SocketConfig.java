package com.prashantMaurya.PSO.Configuration;

import com.prashantMaurya.PSO.Components.TextSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {

  private final TextSocketHandler myWebSocketHandler;

  public SocketConfig(TextSocketHandler myWebSocketHandler) {
    this.myWebSocketHandler = myWebSocketHandler;
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry
        .addHandler(myWebSocketHandler, "/game-ws")
        .setAllowedOriginPatterns("*"); // Adjust allowed origins as needed
  }
}
