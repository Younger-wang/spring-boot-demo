package com.wyg.webmvc.config;

import com.wyg.webmvc.filter.MyFilter;
import com.wyg.webmvc.linstener.MyListener;
import com.wyg.webmvc.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
// 全面接管SpringMVC
//@EnableWebMvc
public class MyMvcConfig {
    /**
     * 注册servlet
     *
     * @return servlet
     */
    @Bean
    public ServletRegistrationBean<MyServlet> myHttpServlet() {
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }

    /**
     * 注册filter
     *
     * @return filter
     */
    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/myServlet", "/user"));
        return bean;
    }

    /**
     * 注册Listener
     *
     * @return listener
     */
    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener() {
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
}
