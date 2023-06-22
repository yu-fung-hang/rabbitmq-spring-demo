package com.yufunghang.demo.amqp.event;

import com.yufunghang.demo.model.DemoMessage;

public interface DemoEvent {
    void sthHappened(DemoMessage demoMessage);
}
