package com.example.kitchenengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KitchenSenderService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Scheduled(fixedRate = 1000)
    public void send() {
//        System.out.println("Hello world");
//        kafkaTemplate.send("test2", "Hello");
    }
}
