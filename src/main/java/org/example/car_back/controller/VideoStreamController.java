package org.example.car_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/video")
public class VideoStreamController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String REDIS_KEY = "video_stream_frames";

    @GetMapping("/latest-frame")
    public String getLatestFrame() {
        // 从 Redis 获取最新图像帧
        return redisTemplate.opsForList().index(REDIS_KEY, 0);
    }
}
