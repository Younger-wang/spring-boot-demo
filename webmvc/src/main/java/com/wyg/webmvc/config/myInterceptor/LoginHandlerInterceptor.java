package com.wyg.webmvc.config.myInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginName = request.getSession().getAttribute("loginName");
        if (loginName == null) {
            // 未登录，进行跳转到登录页面的操作
            request.setAttribute("msg","未登录");
            // 转发到登录页面
            request.getRequestDispatcher("/login.html").forward(request, response);
            // 请求拦截
            return false;
        }
        // 请求放行
        return true;
    }
}
