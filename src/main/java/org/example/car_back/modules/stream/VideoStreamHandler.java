package org.example.car_back.modules.stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.TimeUnit;

@Component
public class VideoStreamHandler extends TextWebSocketHandler {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String REDIS_KEY = "video_stream_frames"; // Redis 列表键名
    private static final int MAX_FRAMES = 100; // Redis 列表最大长度

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String videoFrame = message.getPayload(); // 接收到的 Base64 图像帧
        storeFrameInRedis(videoFrame);           // 存储到 Redis
    }

    private void storeFrameInRedis(String videoFrame) {
        // 将图像帧存储到 Redis 列表
        redisTemplate.opsForList().leftPush(REDIS_KEY, videoFrame);

        // 限制列表长度，防止无限增长
        redisTemplate.opsForList().trim(REDIS_KEY, 0, MAX_FRAMES - 1);

        // 设置过期时间，例如：5分钟
        redisTemplate.expire(REDIS_KEY, 5, TimeUnit.MINUTES);
    }
}
