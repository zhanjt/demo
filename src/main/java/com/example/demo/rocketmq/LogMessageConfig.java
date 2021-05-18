package com.example.demo.rocketmq;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class LogMessageConfig {

    @Value("${ctid.maintenance.ReceiveMq.namesrvAddr}")
    private String namesrvAddr;


    @Value("${ctid.maintenance.ReceiveMq.consumerGroupName}")
    private String consumerGroupName;
    @Value("${ctid.maintenance.ReceiveMq.instanceName}")
    private String instanceName;

}
