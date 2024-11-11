package org.example.car_back.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName car_user_binding
 */
@TableName(value ="car_user_binding")
@Data
public class CarUserBinding implements Serializable {
    /**
     * 
     */
    private String car_id;

    /**
     * 
     */
    private String user_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}