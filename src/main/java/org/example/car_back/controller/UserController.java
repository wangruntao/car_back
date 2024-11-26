package org.example.car_back.controller;

import jakarta.validation.Valid;
import org.example.car_back.common.R;
import org.example.car_back.domain.User;
import org.example.car_back.dto.LoginRequest;
import org.example.car_back.dto.RegisterRequest;
import org.example.car_back.service.UserService;
import org.example.car_back.utils.JwtUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 用户注册接口
    @PostMapping("/register")
    public R register(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        R validationError = validateBindingResult(bindingResult);
        if (validationError != null) {
            return validationError;
        }

        // 检查用户是否存在
        if (userService.existsByUsername(registerRequest.getUsername())) {
            return R.error("Username already exists");
        }

        // 注册用户
        boolean success = userService.register(registerRequest);
        if (success) {
            logger.info("User registered: " + registerRequest.getUsername());
            return R.success("Register successful!");
        } else {
            return R.error("Register failed");
        }
    }

    // 用户登录接口
    @PostMapping("/login")
    public R login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        R validationError = validateBindingResult(bindingResult);
        if (validationError != null) {
            return validationError;
        }
        // 验证用户
        if (!userService.validateUser(loginRequest.getUsername(), loginRequest.getPassword())) {
            return R.error("Invalid username or password");
        }
        // 生成 JWT Token
        String jwtToken = JwtUtil.generateToken(loginRequest.getUsername());

        logger.info("User logged in: " + loginRequest.getUsername());
        return R.success("Login successful!", jwtToken);
    }

    // 获取当前登录用户的信息接口
    @GetMapping("/current")
    public R getCurrentUser(@RequestHeader("Authorization") String token) {
        // 从 JWT Token 中解析用户信息
        String username = JwtUtil.getUsernameFromToken(token);

        if (username == null) {
            return R.error("Invalid token or not logged in");
        }
        User user = userService.findByUsername(username);
        return R.success(user);
    }

}
