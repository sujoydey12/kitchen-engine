package com.example.kitchenengine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class KitchenConsumerService {


    public static final String KAFKA_SANDBOX = "kafka-sandbox";
    private List<String>messageList = new ArrayList<>();
    private static final String TOPIC_NAME="test3";


    @KafkaListener(topics = TOPIC_NAME, groupId = KAFKA_SANDBOX)
    public String getConsumedMessage(String message) {
        synchronized (message) {
            messageList.add(message);
            log.info(message);
            return message;
        }
    }

    public List<String> getMessage() {
        return messageList;

    }
}
