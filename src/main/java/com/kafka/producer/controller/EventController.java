package com.kafka.producer.controller;

import com.kafka.dto.Customer;
import com.kafka.producer.service.EventMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

    @Autowired
    private EventMessageProducer eventMessageProducer;
/**
    @GetMapping("/message/{message}")
    public ResponseEntity publishMessage(@PathVariable String message)
    {
        try {
            eventMessageProducer.sendMessageToTopic(message);
            return ResponseEntity.ok("message " +message+" published successfully ..");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
**/
    @PostMapping("/publish")
    public ResponseEntity sendEvents(@RequestBody Customer customer)
    {
        eventMessageProducer.sendEventsToTopic(customer);
        return ResponseEntity.ok("message " +customer.toString()+" published successfully ..");
    }

}
