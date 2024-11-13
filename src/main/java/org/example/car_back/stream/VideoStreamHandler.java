package org.example.car_back.stream;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

@Component
public class VideoStreamHandler extends TextWebSocketHandler {

    @Autowired
    private Jedis jedis; // Redis客户端

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 处理WebSocket接收到的视频流消息（例如图像帧）
        String videoFrame = message.getPayload();

        // 将视频流数据存储到Redis，使用流的键（例如“video_stream”）和时间戳作为缓存键
        String redisKey = "video_stream";
        jedis.set(redisKey, videoFrame);  // 存储图像帧或视频数据

        // 确保实时性，可以设定Redis的过期时间，防止过期数据占用内存
        jedis.expire(redisKey, 60); // 设置60秒后过期
    }
}
