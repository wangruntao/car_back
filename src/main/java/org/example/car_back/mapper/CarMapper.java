package org.example.car_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.car_back.domain.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wrt
* @description 针对表【car】的数据库操作Mapper
* @createDate 2024-11-10 23:44:53
* @Entity org.example.car_back.domain.Car
*/
@Mapper
public interface CarMapper extends BaseMapper<Car> {

}




