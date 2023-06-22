package com.yufunghang.demo.amqp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void send(MqMessage message) {
        publisher.publishEvent(message);
    }
}
