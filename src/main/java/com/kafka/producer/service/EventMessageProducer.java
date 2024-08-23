package com.kafka.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EventMessageProducer {

    @Value("${customer.topic.name}")
    private String customerTopic;

    @Autowired
    private KafkaTemplate<String,Customer> custTemplate;

   // @Autowired
    //private KafkaTemplate<String, Object> template;

   public void sendEventsToTopic(Customer customer)
    {
        ObjectMapper mapper = new ObjectMapper();
        //CustomerRec customerRec = mapper.convertValue(customer, CustomerRec.class);
        CompletableFuture<SendResult<String, Customer>> future = custTemplate.send(customerTopic, customer);
        future.whenComplete((re, ex) -> {

            if (ex == null) {
                System.out.println("Sent message=[" +  customer.toString() +
                        "] with offset=[" + re.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        customer.toString() + "] due to : " + ex.getMessage());
            }

        });

    }
}
