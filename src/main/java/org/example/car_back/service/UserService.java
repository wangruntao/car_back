package org.example.car_back.service;

import org.example.car_back.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.car_back.dto.LoginRequest;
import org.example.car_back.dto.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author wrt
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-10 23:45:04
*/

public interface UserService extends IService<User> ,UserDetailsService{

    boolean register(RegisterRequest registerRequest);

    boolean login(LoginRequest loginRequest);

    UserDetails loadUserByUsername(String username);
}
