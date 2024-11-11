package org.example.car_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.car_back.domain.CarControlCommand;
import org.example.car_back.service.CarControlCommandService;
import org.example.car_back.mapper.CarControlCommandMapper;
import org.springframework.stereotype.Service;

/**
* @author wrt
* @description 针对表【car_control_command】的数据库操作Service实现
* @createDate 2024-11-10 23:44:58
*/
@Service
public class CarControlCommandServiceImpl extends ServiceImpl<CarControlCommandMapper, CarControlCommand>
    implements CarControlCommandService{

}




