package com.yufunghang.demo.amqp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImpl implements MessageSender {
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void send(MqMessage message) {
        publisher.publishEvent(message);
    }
}
