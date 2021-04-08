package com.wyg.webmvc.config;

import com.wyg.webmvc.config.myFilter.MyFilter;
import com.wyg.webmvc.config.myInterceptor.LoginHandlerInterceptor;
import com.wyg.webmvc.config.myLinstener.MyListener;
import com.wyg.webmvc.config.myResolver.MyLocaleResolver;
import com.wyg.webmvc.config.myServlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
// 全面接管SpringMVC
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
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

    /**
     * 添加拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                // 排除以下请求
                .excludePathPatterns(Arrays.asList("/user/login","/error","/login.html"));
    }

    /**
     * 自定义国际化解析器
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver myLocaleResolver(){
        return new MyLocaleResolver();
    }
}
