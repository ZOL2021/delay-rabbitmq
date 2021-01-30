package com.zlbteam.config;

import com.zlbteam.constant.DelayRabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayRabbitmqConfig {

    /**
     * 直连
     */

    @Bean
    CustomExchange directExchange() {
        Map<String, Object> args = new HashMap<>(1);
        args.put(DelayRabbitMqConstant.X_DELAYED_TYPE, DelayRabbitMqConstant.DELAY_DIRECT_TYPE);
        return new CustomExchange(DelayRabbitMqConstant.DELAY_DIRECT_EXCHANGE, DelayRabbitMqConstant.X_DELAYED_MESSAGE,true, false, args);
    }

    @Bean
    Queue directQueue(){
        return new Queue(DelayRabbitMqConstant.DELAY_DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding(CustomExchange directExchange, Queue directQueue) {
        return BindingBuilder
                .bind(directQueue)
                .to(directExchange)
                .with(DelayRabbitMqConstant.DELAY_DIRECT_ROUTING)
                .noargs();
    }

    /**
     * 广播
     */

    @Bean
    CustomExchange fanoutExchange() {
        Map<String, Object> args = new HashMap<>(1);
        args.put(DelayRabbitMqConstant.X_DELAYED_TYPE, DelayRabbitMqConstant.DELAY_FANOUT_TYPE);
        return new CustomExchange(DelayRabbitMqConstant.DELAY_FANOUT_EXCHANGE, DelayRabbitMqConstant.X_DELAYED_MESSAGE,true, false, args);
    }

    @Bean
    Queue fanoutQueue(){
        return new Queue(DelayRabbitMqConstant.DELAY_FANOUT_QUEUE);
    }

    @Bean
    public Binding fanoutBinding(CustomExchange fanoutExchange, Queue fanoutQueue) {
        return BindingBuilder
                .bind(fanoutQueue)
                .to(fanoutExchange)
                .with(DelayRabbitMqConstant.DELAY_FANOUT_ROUTING)
                .noargs();
    }

    @Bean
    Queue fanoutSecondQueue(){
        return new Queue(DelayRabbitMqConstant.DELAY_FANOUT_QUEUE + "SECOND");
    }

    @Bean
    public Binding fanoutSecondBinding(CustomExchange fanoutExchange, Queue fanoutSecondQueue) {
        return BindingBuilder
                .bind(fanoutSecondQueue)
                .to(fanoutExchange)
                .with(DelayRabbitMqConstant.DELAY_FANOUT_ROUTING)
                .noargs();
    }

    /**
     * 主题
     * # : 匹配任意多个单词
     * * : 匹配一个单词
     * . : 分割单词
     */

    @Bean
    CustomExchange topicExchange() {
        Map<String, Object> args = new HashMap<>(1);
        args.put(DelayRabbitMqConstant.X_DELAYED_TYPE, DelayRabbitMqConstant.DELAY_TOPIC_TYPE);
        return new CustomExchange(DelayRabbitMqConstant.DELAY_TOPIC_EXCHANGE, DelayRabbitMqConstant.X_DELAYED_MESSAGE,true, false, args);
    }

    @Bean
    Queue topicQueue(){
        return new Queue(DelayRabbitMqConstant.DELAY_TOPIC_QUEUE);
    }

    @Bean
    public Binding topicBinding(CustomExchange topicExchange, Queue topicQueue) {
        return BindingBuilder
                .bind(topicQueue)
                .to(topicExchange)
                .with(DelayRabbitMqConstant.DELAY_TOPIC_ROUTING + ".*")
                .noargs();
    }

    @Bean
    Queue topicSecondQueue(){
        return new Queue(DelayRabbitMqConstant.DELAY_TOPIC_QUEUE + "SECOND");
    }

    @Bean
    public Binding topicSecondBinding(CustomExchange topicExchange, Queue topicSecondQueue) {
        return BindingBuilder
                .bind(topicSecondQueue)
                .to(topicExchange)
                .with(DelayRabbitMqConstant.DELAY_TOPIC_ROUTING + ".#")
                .noargs();
    }

    @Bean
    Queue topicThirdQueue(){
        return new Queue(DelayRabbitMqConstant.DELAY_TOPIC_QUEUE + "THIRD");
    }

    @Bean
    public Binding topicThirdBinding(CustomExchange topicExchange, Queue topicThirdQueue) {
        return BindingBuilder
                .bind(topicThirdQueue)
                .to(topicExchange)
                .with("#." + DelayRabbitMqConstant.DELAY_TOPIC_ROUTING + ".#")
                .noargs();
    }

    /**
     * 头部
     * 无法使用延时队列
     */

}
