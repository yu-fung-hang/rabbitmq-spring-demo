package com.yufunghang.demo.amqp.consumer;

import com.yufunghang.demo.amqp.event.DemoEvent;
import com.yufunghang.demo.model.DemoMessage;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer implements DemoEvent {
    @Override
    public void sthHappened(DemoMessage message) {
        if(message != null) {
            // do some business here
        }
    }
}