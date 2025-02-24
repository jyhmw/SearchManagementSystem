package com.jyhmw.filiter;

import com.jyhmw.service.UserService;
import com.jyhmw.util.TokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    private static final String LOGIN_PATH = "/auth/login"; // 登录路径
    private static final String REGISTER_PATH = "/auth/register"; //注册路径

    /**
     * 过滤每个请求，用于验证每个请求中token的有效性
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        //这两个路径跳过jwt验证
        if (request.getRequestURI().equals(LOGIN_PATH) || request.getRequestURI().equals(REGISTER_PATH)) {
            filterChain.doFilter(request, response); // 跳过 JWT 验证
            return;
        }
        if (token != null && tokenUtil.validateToken(token)) {
            try {
                if (tokenUtil.needRefresh(token)) {
                    log.info("重新生成token");
                    String refreshedToken = tokenUtil.refreshToken(token);
                    response.setHeader("X-Refreshed-Token", refreshedToken);
                }
                String username = tokenUtil.getUserNameFromToken(token);
                UserDetails userDetails = new User(username, "", new ArrayList<>());
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            filterChain.doFilter(request, response);
        }
    }
}
