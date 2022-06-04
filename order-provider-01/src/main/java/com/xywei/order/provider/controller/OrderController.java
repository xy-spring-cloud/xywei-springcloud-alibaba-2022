package com.xywei.order.provider.controller;

import com.xywei.order.provider.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RefreshScope
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/getOrder")
    public String getOrderNo() {
        return orderService.getOrderNo();
    }

}
