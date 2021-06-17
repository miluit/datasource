package com.taotao.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitConfig {

    @Value("${com.taotao.firstqueue}")
    private String firstQueue;

    @Value("${com.taotao.directexchange}")
    private String directExchange;

    @Bean("firstQueue")
    public Queue getFirstQueue() {
        return new Queue(firstQueue);
    }

    @Bean("firstDirectExchange")
    public DirectExchange getDirectExchange(){
        return new DirectExchange(directExchange);
    }

    /**
     * 直连
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue, @Qualifier("firstDirectExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao.best");
    }

    /**
     * 在消费端转换JSON消息
     * 监听类都要加上containerFactory属性
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }

}
