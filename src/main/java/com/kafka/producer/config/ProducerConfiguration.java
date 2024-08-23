package com.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {

    @Value("${message.topic.name}")
    private String messageTopic;

    @Value("${customer.topic.name}")
    private String customerTopic;

    @Bean
    public NewTopic createTopic()
    {
        return new NewTopic(messageTopic, 5, (short) 1);
    }

    @Bean
    public NewTopic createCustomerTopic()
    {
        return new NewTopic(customerTopic, 3, (short) 1);
    }

}
