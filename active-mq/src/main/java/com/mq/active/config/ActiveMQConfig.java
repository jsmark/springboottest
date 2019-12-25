package com.mq.active.config;

import lombok.Data;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Data
@Configuration
public class ActiveMQConfig {
    @Value("${queueName}")
    private String queueName;

    @Value("${topicName}")
    private String topicName;

    @Value("${spring.activemq.user}")
    private String usrName;

    @Value("${spring.activemq.password}")
    private  String password;

    @Value("${spring.activemq.broker-url}")
    private  String brokerUrl;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queueName);
    }

}
