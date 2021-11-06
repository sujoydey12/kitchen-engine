package com.example.kitchenengine.controllers;


import com.example.kitchenengine.domain.CustomerTable;
import com.example.kitchenengine.service.KitchenConsumerService;
import com.example.kitchenengine.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final KitchenConsumerService kitchenConsumerService;


    @PostMapping("sendOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendOrder(@RequestBody CustomerTable table) {
        orderService.sendOrderConfirm(table);
    }

    @GetMapping("/retrieveAllMessages")
    public List<String> getMessage() {
        return kitchenConsumerService.getMessage();
    }

}
