package com.example.kitchenengine.controllers;


import com.example.kitchenengine.domain.Table;
import com.example.kitchenengine.service.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("sendOrder")
    public void sendOrder(@RequestBody Table table) {
        orderService.sendOrderConfirm(table);
    }

    @GetMapping("/test")
    @Timed("1")
    public String getTest() {
        return "test";
    }
}
