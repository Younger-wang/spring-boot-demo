package com.wyg.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、@SpringBootApplication 主程序入口类，说明当前是springboot应用
 */
// 导入spring的配置文件，让内容生效，springboot不建议使用，直接使用配置类即可
@ImportResource(value = "classpath:conf/beans.xml")
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
