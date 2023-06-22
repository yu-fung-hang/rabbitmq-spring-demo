package com.yufunghang.demo.amqp.common;

import lombok.Data;

@Data
public class MqMessage {
    private String exchange;
    private String routingKey;
    private Object message;

    public MqMessage(String exchange, String routingKey, Object message) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.message = message;
    }
}
