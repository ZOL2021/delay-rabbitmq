package com.zlbteam.publish;

import com.zlbteam.constant.DelayRabbitMqConstant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DelayRabbitmqPublish {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendDirectMessage(Map<String, String> msg) {
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DelayRabbitMqConstant.DELAY_DIRECT_EXCHANGE, DelayRabbitMqConstant.DELAY_DIRECT_ROUTING, msg, (MessagePostProcessor) message -> {
            //给消息设置延迟毫秒值
            message.getMessageProperties().setHeader("x-delay", 5000L);
            return message;
        });
    }

    public void sendFanoutMessage(Map<String, String> msg) {
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DelayRabbitMqConstant.DELAY_FANOUT_EXCHANGE, DelayRabbitMqConstant.DELAY_FANOUT_ROUTING, msg, (MessagePostProcessor) message -> {
            //给消息设置延迟毫秒值
            message.getMessageProperties().setHeader("x-delay", 5000L);
            return message;
        });
    }

    public void sendTopicMessage(String rout, Map<String, String> msg) {
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DelayRabbitMqConstant.DELAY_TOPIC_EXCHANGE, DelayRabbitMqConstant.DELAY_TOPIC_ROUTING + rout, msg, (MessagePostProcessor) message -> {
            //给消息设置延迟毫秒值
            message.getMessageProperties().setHeader("x-delay", 5000L);
            return message;
        });
    }
}
