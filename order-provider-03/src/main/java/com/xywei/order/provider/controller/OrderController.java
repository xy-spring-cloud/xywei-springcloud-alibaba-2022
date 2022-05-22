package com.xywei.order.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RefreshScope
@RestController
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Value(("${app.version}"))
    private String appVersion;

    @Value("${spring.profiles.active}")
    private String env;

    @GetMapping("/getOrder")
    public String getOrderNo() {
        return UUID.randomUUID().toString() + ":" + env + ":" + port + ":" + appVersion;
    }

}
