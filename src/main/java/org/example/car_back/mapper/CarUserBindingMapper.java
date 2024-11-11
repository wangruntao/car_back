package org.example.car_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.car_back.domain.CarUserBinding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wrt
* @description 针对表【car_user_binding】的数据库操作Mapper
* @createDate 2024-11-10 23:45:01
* @Entity org.example.car_back.domain.CarUserBinding
*/
@Mapper
public interface CarUserBindingMapper extends BaseMapper<CarUserBinding> {

    boolean checkBinding(int userId, int carId);

    void insertBinding(int userId, int carId);
}




