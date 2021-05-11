package com.wug.myamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MyAmqpApplicationTests {

	@Value("${myMessage.EXCHANGE_ATGUIGU_DIRECT}")
	private String EXCHANGE_ATGUIGU_DIRECT;
	@Value("${myMessage.EXCHANGE_ATGUIGU_FANOUT}")
	private String EXCHANGE_ATGUIGU_FANOUT;
	@Value("${myMessage.EXCHANGE_ATGUIGU_TOPIC}")
	private String EXCHANGE_ATGUIGU_TOPIC;
	@Value("${myMessage.QUEUE_ATGUIGU}")
	private String QUEUE_ATGUIGU;
	@Value("${myMessage.QUEUE_ATGUIGU_EMPS}")
	private String QUEUE_ATGUIGU_EMPS;
	@Value("${myMessage.QUEUE_ATGUIGU_NEWS}")
	private String QUEUE_ATGUIGU_NEWS;
	@Value("${myMessage.QUEUE_GULIXUEYUAN_NEWS}")
	private String QUEUE_GULIXUEYUAN_NEWS;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Test
	public void send() {
		// 这个方法是需要自己转换message。
//		rabbitTemplate.send(exchange, routingKey, message);
		Map<String, Object> map = new HashMap<>();
		map.put("msg","1223");
		map.put("list", Collections.singletonList("a,b,c"));
		rabbitTemplate.convertAndSend(EXCHANGE_ATGUIGU_DIRECT, QUEUE_ATGUIGU_EMPS, map);
		rabbitTemplate.convertAndSend(EXCHANGE_ATGUIGU_FANOUT, "", map);
	}

	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert(QUEUE_ATGUIGU_EMPS);
		Object o1 = rabbitTemplate.receiveAndConvert(QUEUE_ATGUIGU_NEWS);
		Object o2 = rabbitTemplate.receiveAndConvert(QUEUE_GULIXUEYUAN_NEWS);
		assert o != null;
		System.out.println(o.getClass());
		System.out.println(o);
		System.out.println(o1);
		System.out.println(o2);
	}

	@Test
	void contextLoads() {
	}

}
