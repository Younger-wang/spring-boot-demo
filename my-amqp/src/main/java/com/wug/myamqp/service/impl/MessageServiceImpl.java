package com.wug.myamqp.service.impl;

import com.wug.myamqp.service.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageServiceImpl implements MessageService {

    @Value("${myMessage.QUEUE_ATGUIGU}")
    private String QUEUE_ATGUIGU;

    @Bean
    private String QUEUE_ATGUIGU(){
        return QUEUE_ATGUIGU;
    }


//    @RabbitListener(queues = "${myMessage.QUEUE_ATGUIGU}")
    @RabbitListener(queues = "#{QUEUE_ATGUIGU}")
    @Override
    public void receive(Map<String, Object> objectMap) {
        System.out.println(QUEUE_ATGUIGU);
        System.out.println(objectMap);
    }
}
