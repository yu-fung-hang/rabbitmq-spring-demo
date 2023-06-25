package com.yufunghang.demo.amqp.consumer;

import com.yufunghang.demo.amqp.event.DemoEvent;
import com.yufunghang.demo.model.DemoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoConsumer implements DemoEvent {
    @Override
    public void sthHappened(DemoMessage message) {
        if(message != null) {
            log.info("Consumer: consuming a message...");
            log.info(message.getContent());
            log.info("Consumer: a message has been consumed");
        }
    }
}