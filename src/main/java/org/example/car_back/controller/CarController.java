package org.example.car_back.controller;

import org.example.car_back.common.R;
import org.example.car_back.domain.Car;
import org.example.car_back.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public R addCar(@RequestBody Car car) {
        carService.addCar(car);
        return R.success("Car added successfully!");
    }
    @GetMapping
    public R getAllCars() {
        List<Car> cars =  carService.getAllCars();
        return R.success(cars);
    }
    @GetMapping("/{carId}")
    public R getCarById(@PathVariable int carId) {
        Car car = carService.getCarById(carId);
        return R.success(car);
    }
}
