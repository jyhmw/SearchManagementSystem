package com.jyhmw;

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
    @Test
    void testPasswordUtil() throws NoSuchAlgorithmException {
        String token = tokenUtil.generateToken("1");
        log.info("token:{}", token);
        boolean b = tokenUtil.validateToken(token);
        log.info(String.valueOf(b));
        String userId = tokenUtil.getUserIdFromToken(token);
        log.info(userId);
    }

}
