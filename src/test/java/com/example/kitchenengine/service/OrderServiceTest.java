package com.example.kitchenengine.service;

import com.example.kitchenengine.domain.Status;
import com.example.kitchenengine.domain.CustomerTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static com.example.kitchenengine.service.KitchenSenderService.TOPIC;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    KafkaTemplate<String,String>kafkaTemplate;
    @Mock
    ObjectMapper objectMapper;
    @InjectMocks
    OrderService orderService;

    @Test
    public void testOrder() throws JsonProcessingException {

        orderService
                .sendOrderConfirm(CustomerTable.builder().id(1)
                        .tableNo(2)
                        .status(Status.READY_TO_ORDER).build());
        String payload = objectMapper.writeValueAsString(CustomerTable.builder().id(1)
                .tableNo(2)
                .status(Status.READY_TO_ORDER).build());

        verify(kafkaTemplate).send(TOPIC,payload);




    }
}
