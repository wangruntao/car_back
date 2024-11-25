package org.example.car_back.config;

import org.example.car_back.modules.stream.PointCloudHandler;
import org.example.car_back.modules.stream.VideoStreamHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new VideoStreamHandler(), "/video-stream")
                .addHandler(new PointCloudHandler(), "/point-cloud-stream")
                .setAllowedOrigins("*");
    }
}
