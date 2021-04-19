package com.wyg.webmvc.controller;

import com.wyg.auto.conf.service.HelloService;
import com.wyg.webmvc.config.myException.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    private final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    /**
     * 这里使用的是自定义的starter中的service
     */
    @Autowired
    private HelloService helloService;

    @GetMapping("/user/login")
    public String login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, Map<String, String> map, HttpSession session) {
        if ("admin".equals(loginName) && "123456".equals(password)) {
            // 登录成功
            LOG.info("登录成功");
            // 将loginName放入session，方便后续进行拦截
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

    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello() {
        return helloService.sayHello();
    }
}
