package com.jyhmw;

import com.jyhmw.entity.User;
import com.jyhmw.mapper.UserMapper;
import com.jyhmw.util.PasswordUtil;
import com.jyhmw.util.TokenUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
@Slf4j
class SearchManagementSystemApplicationTests {
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    PasswordUtil passwordUtil;
    @Autowired
    UserMapper userMapper;
    @Test
    void testTokenUtil() throws NoSuchAlgorithmException {
        String token = tokenUtil.generateToken("1");
        log.info("token:{}", token);
        boolean b = tokenUtil.validateToken(token);
        log.info(String.valueOf(b));
        String userId = tokenUtil.getUserNameFromToken(token);
        log.info(userId);
    }

    @Test
    void testPasswordUtil() {
        String password = "123456";
        String s = passwordUtil.encryptPassword(password);
        System.out.println(s);
    }

    @Test
    void testUserMapper() {
        User user = new User();
        user.setName("Ben");
        user.setContact("15935540446");
        user.setPassword(passwordUtil.encryptPassword("123456"));
        user.setRoleId(1);
        user.setSchool("中北大学");
        user.setUsername("xs_ben");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }


}
