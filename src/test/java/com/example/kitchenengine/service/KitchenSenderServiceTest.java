package com.example.kitchenengine.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static com.example.kitchenengine.service.KitchenSenderService.TOPIC;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KitchenSenderServiceTest {

    @Mock
    KafkaTemplate<String,String>kafkaTemplate;
    @InjectMocks
    KitchenSenderService kitchenSenderService;

    @Test
    void sendHeartRequest() {
        kitchenSenderService.sendHeartRequest();
        verify(kafkaTemplate).send(TOPIC,"Pinging if your up");
    }
}