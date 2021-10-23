package com.example.kitchenengine.service;


import com.example.kitchenengine.domain.Table;
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

    @SneakyThrows
    public void sendOrderConfirm(Table table){
        String json = objectMapper.writeValueAsString(table);
        kafkaTemplate.send("test2",json);
    }

}
