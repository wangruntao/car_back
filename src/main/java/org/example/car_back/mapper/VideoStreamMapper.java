package org.example.car_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.car_back.domain.VideoStream;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wrt
* @description 针对表【video_stream】的数据库操作Mapper
* @createDate 2024-11-10 23:45:06
* @Entity org.example.car_back.domain.VideoStream
*/
@Mapper
public interface VideoStreamMapper extends BaseMapper<VideoStream> {

}




