package com.wyg.auto.conf.service.Impl;

import com.wyg.auto.conf.properties.HelloProperties;
import com.wyg.auto.conf.service.HelloService;
import lombok.Getter;
import lombok.Setter;

/**
 * 这是自动配置类的具体实现service，在autoConfiguration自动配置类中进行注入
 */
public class HelloServiceImpl implements HelloService {

    @Getter
    @Setter
    HelloProperties helloProperties;

    @Override
    public String sayHello() {
        return helloProperties.getPrefix() + "这是一个starter" + helloProperties.getSuffix();
    }
}
