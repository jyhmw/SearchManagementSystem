package com.jyhmw.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 本方法使用SHA-256加密方法
 */
@Component
public class TokenUtil {
    private static final String SECRET_KEY = "jyhdw";
    private static final long EXPIRATION_TIME = 30 * 60 * 1000; //有效时间半小时


    public static byte[] expandKey(String secretKey) throws NoSuchAlgorithmException {
        //单向哈希函数，将任意长度的数据转换为固定长度
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = secretKey.getBytes();
        byte[] expandedKey = digest.digest(keyBytes);
        return expandedKey;
    }

    /**
     * 生成加密后的token
     * @param username
     * @return
     */
    public String generateToken(String username) throws NoSuchAlgorithmException {
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, expandKey(SECRET_KEY))
                .compact();
        return token;
    }

    /**
     * 验证token方法
     * @param token
     * @return
     */
    public boolean validateToken(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(expandKey(SECRET_KEY))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 通过token获得用户ID
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token) throws NoSuchAlgorithmException {
        Claims claims = Jwts.parser()
                .setSigningKey(expandKey(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
