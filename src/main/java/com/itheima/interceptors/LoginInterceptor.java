package com.itheima.interceptors;

import com.itheima.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String token = request.getHeader("Authorization");
            Map<String, Object> claims = JwtUtil.parseToken(token);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            if (operations.get(token) == null) {
                throw new RuntimeException();
            }
            //放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);//约定好的状态码
            //不放行
            return false;
        }
    }
}
