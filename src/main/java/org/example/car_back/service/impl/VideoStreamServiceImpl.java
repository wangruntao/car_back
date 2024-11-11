package org.example.car_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.car_back.domain.VideoStream;
import org.example.car_back.service.VideoStreamService;
import org.example.car_back.mapper.VideoStreamMapper;
import org.springframework.stereotype.Service;

/**
* @author wrt
* @description 针对表【video_stream】的数据库操作Service实现
* @createDate 2024-11-11 00:04:08
*/
@Service
public class VideoStreamServiceImpl extends ServiceImpl<VideoStreamMapper, VideoStream>
    implements VideoStreamService{

}




