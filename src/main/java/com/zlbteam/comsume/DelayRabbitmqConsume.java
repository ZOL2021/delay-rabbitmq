package com.zlbteam.comsume;

import com.zlbteam.constant.DelayRabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DelayRabbitmqConsume {

    @RabbitListener(queues = DelayRabbitMqConstant.DELAY_DIRECT_EXCHANGE)
    public void directConsume(Map<String, String> map) {
        String direct = map.get("direct");
        System.out.println(direct);
    }

    @RabbitListener(queues = DelayRabbitMqConstant.DELAY_FANOUT_QUEUE)
    public void fanoutConsume(Map<String, String> map) {
        String fanout = map.get("fanout");
        System.out.println(fanout+ 1);
    }

    @RabbitListener(queues = DelayRabbitMqConstant.DELAY_FANOUT_QUEUE+"SECOND")
    public void fanoutSecondConsume(Map<String, String> map) {
        String fanout = map.get("fanout");
        System.out.println(fanout+ 2);
    }

    @RabbitListener(queues = DelayRabbitMqConstant.DELAY_TOPIC_QUEUE)
    public void topicConsume(Map<String, String> map) {
        String topic = map.get("topic");
        System.out.println(topic + 1);
    }

    @RabbitListener(queues = DelayRabbitMqConstant.DELAY_TOPIC_QUEUE+"SECOND")
    public void topicSecondConsume(Map<String, String> map) {
        String topic = map.get("topic");
        System.out.println(topic+ 2);
    }

    @RabbitListener(queues = DelayRabbitMqConstant.DELAY_TOPIC_QUEUE+"THIRD")
    public void topicThirdConsume(Map<String, String> map) {
        String topic = map.get("topic");
        System.out.println(topic+ 3);
    }
}
