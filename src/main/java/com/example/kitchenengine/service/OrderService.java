package com.example.kitchenengine.service;


import com.example.kitchenengine.domain.CustomerTable;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final KafkaTemplate<String,String>kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String TOPIC = "test2";

    @SneakyThrows
    public void sendOrderConfirm(CustomerTable table){
        String payload = objectMapper.writeValueAsString(table);
        kafkaTemplate.send(TOPIC,payload);
    }

}
