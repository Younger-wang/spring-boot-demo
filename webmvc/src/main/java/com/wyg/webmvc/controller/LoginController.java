package com.wyg.webmvc.controller;

import com.wyg.webmvc.exception.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    private final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/user/login")
    public String login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, Map<String, String> map, HttpSession session) {
        if ("admin".equals(loginName) && "123456".equals(password)) {
            // 登录成功
            LOG.info("登录成功");
            session.setAttribute("loginName", loginName);
            //重定向请求，防止表单重复提交
            return "redirect:/main.html";
        } else {
            LOG.info("登录失败");
            if ("aaa".equals(loginName)) {
                throw new UserNotExistException();
            }
            // 登录失败
            map.put("msg", "用户名密码错误");
            return "/login.html";
        }
    }
}
