package org.example.car_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.car_back.domain.User;
import org.example.car_back.dto.LoginRequest;
import org.example.car_back.dto.RegisterRequest;
import org.example.car_back.service.UserService;
import org.example.car_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
* @author wrt
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-10 23:45:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;


    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean register(RegisterRequest registerRequest) {
        // 检查用户名是否已存在
        if (userMapper.selectByUsername(registerRequest.getUsername()) != null) {
            return false;
        }

        // 创建新的 User 对象
        User user = new User();
        user.setUsername(registerRequest.getUsername());
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // 加密密码
        user.setPassword(registerRequest.getPassword());
        user.setContactInfo(registerRequest.getContactInfo());

        // 插入到数据库
        userMapper.insertUser(user);
        return true;
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        User user = userMapper.selectByUsername(loginRequest.getUsername());
        return user != null && user.getPassword().equals(loginRequest.getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库获取用户信息
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // 返回用户详情对象
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("USER")
        );
    }
}




