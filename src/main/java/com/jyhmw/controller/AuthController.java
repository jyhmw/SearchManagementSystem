package com.jyhmw.controller;

import com.jyhmw.entity.User;
import com.jyhmw.service.UserService;
import com.jyhmw.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasswordUtil passwordUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public RestResponse Login(@RequestBody Map<String, String> loginInformation) throws NoSuchAlgorithmException {
        String username = loginInformation.get("username");
        String password = loginInformation.get("password");
        User user = userService.getByUserName(username);
        if (user == null) {
            return RestResponseUtils.fail("用户不存在，请先注册");
        }
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginInformation.get("username"), loginInformation.get("password")));
            String token = tokenUtil.generateToken(authenticate.getName());
            log.info("验证成功");
            return RestResponseUtils.success(token, "登陆成功！");
        } catch (AuthenticationException e) {
            return RestResponseUtils.fail("密码错误！");
        } catch (NoSuchAlgorithmException e) {
            return RestResponseUtils.fail("加密算法不可用");
        }

    }

    @PostMapping("/register")
    public RestResponse Register(@RequestBody Map<String, String> registerInformation) {
        User user = new User();
        user.setUsername(registerInformation.get("username"));

        return null;
    }

 }
