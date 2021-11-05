package com.example.kitchenengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KitchenSenderService {

    public static final String TOPIC = "test2";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedDelay = 1000l)
    public void sendHeartRequest() {
        kafkaTemplate.send(TOPIC, "Pinging if your up");
    }
}
