package org.example.car_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.car_back.domain.CarControlCommand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wrt
* @description 针对表【car_control_command】的数据库操作Mapper
* @createDate 2024-11-10 23:44:58
* @Entity org.example.car_back.domain.CarControlCommand
*/
@Mapper
public interface CarControlCommandMapper extends BaseMapper<CarControlCommand> {

}




