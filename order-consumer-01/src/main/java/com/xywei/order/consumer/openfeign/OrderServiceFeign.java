package com.xywei.order.consumer.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "${provider.order-provider}")
public interface OrderServiceFeign {

    @GetMapping("/getOrder")
    String getOrder();

}
