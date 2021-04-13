package com.wyg.mydata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyg.mydata.mapper")
public class MyDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDataApplication.class, args);
	}

}
