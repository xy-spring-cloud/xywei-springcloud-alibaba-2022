package com.xywei.order.consumer.controller;

import com.xywei.order.consumer.openfeign.OrderServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private OrderServiceFeign orderServiceFeign;

    @GetMapping("/getOrder")
    public String getOrder() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("order.provider");
        log.info("serviceInstance is: {}", serviceInstance);
        String requestUrl = String.format("http://%s:%s/getOrder", serviceInstance.getHost(), serviceInstance.getPort());
        String result = restTemplate.getForObject(requestUrl, String.class);
        return result;
    }

    @GetMapping("/getOrderByFeign")
    public String getOrderByFeign() {
        return orderServiceFeign.getOrder();
    }

}
