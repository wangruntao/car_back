package org.example.car_back.controller;

import jakarta.validation.Valid;
import org.example.car_back.common.R;
import org.example.car_back.dto.LoginRequest;
import org.example.car_back.dto.RegisterRequest;
import org.example.car_back.service.UserService;
import org.example.car_back.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    // 用户注册接口
    @PostMapping("/register")
    public R register(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        R validationError = validateBindingResult(bindingResult);
        if (validationError != null) {
            return validationError;
        }
        boolean success = userService.register(registerRequest);
        if (!success) {
            return R.error("Register failed: User already exists or other errors");
        }

        logger.info("User registered: " + registerRequest.getUsername());
        return R.success("Register successful!");
    }

    // 用户登录接口
    @PostMapping("/login")
    public R login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        R validationError = validateBindingResult(bindingResult);
        if (validationError != null) {
            return validationError;
        }

        // 认证过程
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 生成JWT Token
        String jwtToken = JwtUtil.generateToken(authentication);

        logger.info("User logged in: " + loginRequest.getUsername());
        return R.success("Login successful!", jwtToken);
    }

    // 用户登出接口
    @PostMapping("/logout")
    public R logout() {
        // 清除用户的认证信息
        SecurityContextHolder.clearContext();
        logger.info("User logged out");

        return R.success("Logout successful!");
    }

    // 获取当前登录用户的信息接口
    @GetMapping("/current")
    public R getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return R.error("Authentication failed or not logged in");
        }

        return R.success(authentication.getPrincipal());
    }
}
