package com.wug.myamqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitAutoConfiguration rabbit自动配置类
 * 	1、CachingConnectionFactory创建rabbit连接工厂
 * 	2、RabbitProperties 封装了rabbitMq的所有配置
 * 	3、RabbitTemplate rabbitMq模板类
 * 	4、AmqpAdmin rabbit系统管理组件，创建队列，交换器等。
 * 使用@EnableRabbit
 */
@EnableRabbit
@SpringBootApplication
public class MyAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAmqpApplication.class, args);
	}

}
