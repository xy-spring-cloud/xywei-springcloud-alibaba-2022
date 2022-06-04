package com.xywei.order.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class OrderService {

    @Value("${server.port}")
    private Integer port;

    @Value(("${app.version}"))
    private String appVersion;

    @Value("${spring.profiles.active}")
    private String env;

    @SentinelResource(value = "/getOrderNo", blockHandler = "getOrderNoExceptionHandler")
    public String getOrderNo() {
        // 模拟流控
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("InterruptedException, ", e);
        }
        return UUID.randomUUID().toString() + ":" + env + ":" + port + ":" + appVersion;
    }

    public String getOrderNoExceptionHandler(BlockException blockException) {
        return "被流控了";
    }

}
