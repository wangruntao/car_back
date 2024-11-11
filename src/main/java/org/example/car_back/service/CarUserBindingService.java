package org.example.car_back.service;

import org.example.car_back.domain.CarUserBinding;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wrt
* @description 针对表【car_user_binding】的数据库操作Service
* @createDate 2024-11-10 23:45:01
*/
public interface CarUserBindingService extends IService<CarUserBinding> {

    void bindCar(int userId, int carId);
}
