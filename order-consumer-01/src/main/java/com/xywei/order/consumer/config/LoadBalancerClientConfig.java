package com.xywei.order.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerClientConfig {

    @Bean
    public LoadBalancerClient loadBalancerClient(LoadBalancerClientFactory loadBalancerClientFactory) {
        return new BlockingLoadBalancerClient(loadBalancerClientFactory);
    }

}
