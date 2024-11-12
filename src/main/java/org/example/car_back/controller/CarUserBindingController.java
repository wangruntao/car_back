package org.example.car_back.controller;


import org.example.car_back.common.R;
import org.example.car_back.service.CarUserBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binding")
public class CarUserBindingController {

    @Autowired
    private CarUserBindingService carUserBindingService;

    // 用户与小车绑定接口
    @PostMapping("/bind")
    public R bindCar(@RequestParam int userId, @RequestParam int carId) {
        carUserBindingService.bindCar(userId, carId);
        return R.success("Car bound successfully!");
    }


}