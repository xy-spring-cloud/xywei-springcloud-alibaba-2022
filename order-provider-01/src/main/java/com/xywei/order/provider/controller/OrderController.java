package com.xywei.order.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getOrder")
    public String getOrderNo() {
        return UUID.randomUUID().toString()+":"+port;
    }

}