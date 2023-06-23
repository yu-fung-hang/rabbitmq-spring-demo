package com.yufunghang.demo.amqp.receiver;

import com.yufunghang.demo.amqp.common.AmqpConst;
import com.yufunghang.demo.amqp.event.DemoEvent;
import com.yufunghang.demo.model.DemoMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DemoReceiver {
    private final List<DemoEvent> events;

    protected final static int MAX_FAILED_TIMES = 3;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = AmqpConst.DEMO_QUEUE),
            exchange = @Exchange(value = AmqpConst.DEMO_EXCHANGE, type = ExchangeTypes.FANOUT),
            key = AmqpConst.DEMO_ROUTING_KEY
    ))
    public void sthHappened(DemoMessage message) throws InterruptedException {
        if (events != null) {
            for (DemoEvent event : events) {
                this.sthHappened(event, message, 0);
            }
        }
    }

    public void sthHappened(DemoEvent event, DemoMessage message, Integer times) throws InterruptedException {
        if (times >= MAX_FAILED_TIMES) {
            return;
        }

        try {
            event.sthHappened(message);
            log.info("Handled by receiver...");
        } catch (Exception e) {
            Thread.sleep(1000);
            this.sthHappened(event, message, ++times);
        }
    }
}
