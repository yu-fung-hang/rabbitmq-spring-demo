package com.yufunghang.demo.amqp.common;

public interface MessageSender {
    void send(MqMessage message);
}
