package com.example.kitchenengine.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KitchenConsumerService {


   // @KafkaListener(topics = "${topic_name}",groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (message){
      //      System.out.println("Consume message -> " +  message);
        }
    }

}
