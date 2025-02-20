package com.jyhmw.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jyhmw.entity.User;
import com.jyhmw.util.Response;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends IService<User>, UserDetailsService {
    User getByUserName(String username);
    UserDetails loadUserByUsername(String username);
}
