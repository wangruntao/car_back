package org.example.car_back.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName video_stream
 */
@TableName(value ="video_stream")
@Data
public class VideoStream implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 
     */
    @TableField(value = "car_id")
    private String car_id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private String user_id;

    /**
     * 
     */
    @TableField(value = "resolution")
    private String resolution;

    /**
     * 
     */
    @TableField(value = "frame_rate")
    private Double frame_rate;

    /**
     * 
     */
    @TableField(value = "bandwidth")
    private Double bandwidth;

    /**
     * 
     */
    @TableField(value = "created_at")
    private LocalDateTime created_at;

    /**
     * 
     */
    @TableField(value = "ended_at")
    private LocalDateTime ended_at;

    /**
     * 
     */
    @TableField(value = "encoding_format")
    private String encoding_format;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}