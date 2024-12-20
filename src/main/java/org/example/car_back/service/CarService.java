package org.example.car_back.service;

import org.example.car_back.domain.Car;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wrt
* @description 针对表【car】的数据库操作Service
* @createDate 2024-11-10 23:44:53
*/
public interface CarService extends IService<Car> {

    void addCar(Car car);

    Car getCarById(int carId);

    List<Car> getAllCars();
}
