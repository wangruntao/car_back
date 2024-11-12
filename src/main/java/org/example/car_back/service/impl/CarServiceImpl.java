package org.example.car_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.car_back.domain.Car;
import org.example.car_back.service.CarService;
import org.example.car_back.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wrt
 * @description 针对表【car】的数据库操作Service实现
 * @createDate 2024-11-10 23:44:53
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
        implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addCar(Car car) {
        carMapper.insert(car);
    }

    @Override
    public Car getCarById(int carId) {
        return carMapper.selectById(carId);
    }

    @Override
    public List<Car> getAllCars() {
        return carMapper.selectList(null);
    }
}




