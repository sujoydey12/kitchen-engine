package com.example.kitchenengine.controllers;


import com.example.kitchenengine.domain.Table;
import com.example.kitchenengine.service.KitchenConsumerService;
import com.example.kitchenengine.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final KitchenConsumerService kitchenConsumerService;


    @PostMapping("sendOrder")
    public void sendOrder(@RequestBody Table table) {
        orderService.sendOrderConfirm(table);
    }

    @GetMapping("/retrieveAllMessages")
    public List<String> getMessage() {
        return kitchenConsumerService.getMessage();
    }

}
