package com.example.kitchenengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KitchenSenderService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void send() {
        kafkaTemplate.send("test2", "Hello");
    }
}
