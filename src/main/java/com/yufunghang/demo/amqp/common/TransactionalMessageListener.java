package com.yufunghang.demo.amqp.common;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionalMessageListener {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 默认在事务提交后执行
     * @param message
     */
    @TransactionalEventListener(fallbackExecution = true)
    public void handleSupplierBillPush(MqMessage message) {
        this.amqpTemplate.convertAndSend(message.getExchange(), message.getRoutingKey(), message.getMessage());
    }
}
