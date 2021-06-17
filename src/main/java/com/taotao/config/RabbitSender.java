package com.taotao.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:rabbitmq.properties")
public class RabbitSender {

    @Value("${com.taotao.firstqueue}")
    private String firstqueue;

    @Value("${com.taotao.directroutingkey}")
    private String directroutingKey;

    @Value("${com.taotao.directexchange}")
    private String directExchange;

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send() throws JsonProcessingException {
        //Brand brand = Brand.builder().id(123).image("image").build();
        amqpTemplate.convertAndSend("",firstqueue,"发送成功");

        //发送json字符串
        /*ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(brand);
        amqpTemplate.convertAndSend(directExchange,directroutingKey,json);*/
    }

}
