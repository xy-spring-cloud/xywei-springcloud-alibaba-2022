package com.xywei.order.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderProviderApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication01.class, args);
    }
}
