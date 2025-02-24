package com.jyhmw.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyhmw.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends IService<User>, UserDetailsService {
    User getByUserName(String username);
    UserDetails loadUserByUsername(String username);

    Page<User> getUsers(int pageNum, int pageSize);
}
