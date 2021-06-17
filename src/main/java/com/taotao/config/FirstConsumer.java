package com.taotao.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:rabbitmq.properties")
@RabbitListener(queues = "firstqueue",containerFactory = "rabbitListenerContainerFactory")
public class FirstConsumer {

    @RabbitHandler
    public void process(String message) {
        System.out.println("First Queue received msg : " + message);
    }

}
