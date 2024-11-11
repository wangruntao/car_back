package org.example.car_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.car_back.domain.Car;
import org.example.car_back.service.CarService;
import org.example.car_back.mapper.CarMapper;
import org.springframework.stereotype.Service;

/**
* @author wrt
* @description 针对表【car】的数据库操作Service实现
* @createDate 2024-11-10 23:44:53
*/
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
    implements CarService{

}




