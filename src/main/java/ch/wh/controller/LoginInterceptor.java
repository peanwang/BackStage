package ch.wh.controller;

import ch.wh.pojo.User;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private String KEY_USER = "USER";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 通过request对象获取Seesion对象
        HttpSession session = request.getSession();
        // 2. 尝试从Siesson域中获取User对象
        User user = (User)session.getAttribute(KEY_USER);
        // 3.判断User是不是为空
        if (user == null) {
            throw new RuntimeException();
        }
        return true;
    }
}