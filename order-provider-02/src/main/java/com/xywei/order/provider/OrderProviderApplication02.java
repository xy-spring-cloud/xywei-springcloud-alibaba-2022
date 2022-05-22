package com.xywei.order.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderProviderApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication02.class, args);
    }
}
