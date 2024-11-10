package org.example.car_back.controller;

import org.example.car_back.common.R;
import org.example.car_back.dto.LoginRequest;
import org.example.car_back.dto.RegisterRequest;
import org.example.car_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    // 用户注册接口
    @PostMapping("/register")
    public R register(@RequestBody RegisterRequest registerRequest) {
        if (!userService.register(registerRequest)) {
            return R.error("Register failed!");
        }
        return R.success("Register successful!");
    }

    // 用户登录接口
    @PostMapping("/login")
    public R login(@RequestBody LoginRequest loginRequest) {
        if (!userService.login(loginRequest)) {
            return R.error("Login failed!");
        }
        return R.success("Login successful!");
    }
}
