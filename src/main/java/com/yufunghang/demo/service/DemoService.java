package com.yufunghang.demo.service;

import com.yufunghang.demo.amqp.common.AmqpConst;
import com.yufunghang.demo.amqp.common.MessageSender;
import com.yufunghang.demo.amqp.common.MqMessage;
import com.yufunghang.demo.model.DemoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoService {
    @Autowired
    private MessageSender messageSender;

    public void demoMethod(String content) {
        DemoMessage message = new DemoMessage(content);
        messageSender.send(new MqMessage(AmqpConst.DEMO_EXCHANGE, AmqpConst.DEMO_ROUTING_KEY, message));
        log.info("Service: a message was sent");
    }
}
