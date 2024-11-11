package org.example.car_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.car_back.domain.CarUserBinding;
import org.example.car_back.service.CarUserBindingService;
import org.example.car_back.mapper.CarUserBindingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author wrt
* @description 针对表【car_user_binding】的数据库操作Service实现
* @createDate 2024-11-10 23:45:00
*/
@Service
public class CarUserBindingServiceImpl extends ServiceImpl<CarUserBindingMapper, CarUserBinding>
    implements CarUserBindingService{
    @Autowired
    private CarUserBindingMapper carUserBindingMapper;
    public void bindCar(int userId, int carId) {
        // 检查用户和车辆是否已绑定
        if (carUserBindingMapper.checkBinding(userId, carId)) {
            throw new RuntimeException("User and car are already bound!");
        }
        // 执行绑定操作
        carUserBindingMapper.insertBinding(userId, carId);
    }
}




