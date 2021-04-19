package com.wyg.auto.conf.config;

import com.wyg.auto.conf.properties.HelloProperties;
import com.wyg.auto.conf.service.HelloService;
import com.wyg.auto.conf.service.Impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这是自定义starter的自动配置类，在这里自动注入了需要的service
 *
 * 一定要将这个autoConfiguration类加入到
 * META-INF/spring.factories文件中，spring才会扫描到配置
 */
@Configuration
// web应用生效
@ConditionalOnWebApplication
// 引入了properties配置类
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {
    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloService helloService() {
        HelloServiceImpl helloService = new HelloServiceImpl();
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }
}
