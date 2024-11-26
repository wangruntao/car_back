package org.example.car_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.car_back.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wrt
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-10 23:45:04
* @Entity org.example.car_back.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(String username);

    void insertUser(User user);

    User findByUsername(String username);

    boolean existsByUsername(String username);
}




