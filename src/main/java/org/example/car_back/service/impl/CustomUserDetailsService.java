package org.example.car_back.service.impl;



import org.example.car_back.domain.User;
import org.example.car_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    private final UserService userService;
    private final UserMapper mapper;
    @Autowired
    public CustomUserDetailsService(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  mapper.selectByUsername(username); // 确保此方法没有调用到 UserDetailsService 的方法
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
