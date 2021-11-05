package com.example.kitchenengine.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KitchenConsumerServiceTest {

    @InjectMocks
    KitchenConsumerService kitchenConsumerService;
    @Mock
    List<String> list;


    @Test
    public void testConsumer() {
        String message = kitchenConsumerService.getConsumedMessage("message");
        verify(list).add("message");
        assertThat(message).isEqualTo("message");
    }
}
