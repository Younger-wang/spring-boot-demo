package com.wyg.myredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.wyg.myredis.mapper")
@SpringBootApplication
@EnableCaching
public class MyRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRedisApplication.class, args);
	}

}
