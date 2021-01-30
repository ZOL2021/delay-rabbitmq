package com.zlbteam.constant;

public class DelayRabbitMqConstant {

    /**
     * : 延迟
     */
    public static final String X_DELAYED_TYPE = "x-delayed-type";

    /**
     * 交换机类型: 延迟交换机
     */
    public static final String X_DELAYED_MESSAGE = "x-delayed-message";

    /**
     * 延迟名称前缀
     */
    public static final String DELAY_NAME = "delay.";

    /**
     * 延迟交换机名称后缀
     */
    public static final String DELAY_EXCHANGE_NAME = "Exchange";

    /**
     * 延迟队列名称后缀
     */
    public static final String DELAY_QUEUE_NAME = "Queue";

    /**
     * 延迟路由名称后缀
     */
    public static final String DELAY_ROUTING_NAME = "Routing";

    /**
     * 直连
     */
    public static final String DELAY_DIRECT_TYPE = "direct";
    public static final String DELAY_DIRECT_EXCHANGE = DELAY_NAME + DELAY_DIRECT_TYPE + DELAY_EXCHANGE_NAME;
    public static final String DELAY_DIRECT_QUEUE = DELAY_NAME + DELAY_DIRECT_TYPE + DELAY_QUEUE_NAME;
    public static final String DELAY_DIRECT_ROUTING = DELAY_NAME + DELAY_DIRECT_TYPE + DELAY_ROUTING_NAME;

    /**
     * 广播
     */
    public static final String DELAY_FANOUT_TYPE = "fanout";
    public static final String DELAY_FANOUT_EXCHANGE = DELAY_NAME + DELAY_FANOUT_TYPE + DELAY_EXCHANGE_NAME;
    public static final String DELAY_FANOUT_QUEUE = DELAY_NAME + DELAY_FANOUT_TYPE + DELAY_QUEUE_NAME;
    public static final String DELAY_FANOUT_ROUTING = DELAY_NAME + DELAY_FANOUT_TYPE + DELAY_ROUTING_NAME;

    /**
     * 主题
     */
    public static final String DELAY_TOPIC_TYPE = "topic";
    public static final String DELAY_TOPIC_EXCHANGE = DELAY_NAME + DELAY_TOPIC_TYPE + DELAY_EXCHANGE_NAME;
    public static final String DELAY_TOPIC_QUEUE = DELAY_NAME + DELAY_TOPIC_TYPE + DELAY_QUEUE_NAME;
    public static final String DELAY_TOPIC_ROUTING = DELAY_NAME + DELAY_TOPIC_TYPE + DELAY_ROUTING_NAME;

    /**
     * 头部
     */
    public static final String DELAY_HEADERS_TYPE = "headers";
    public static final String DELAY_HEADERS_EXCHANGE = DELAY_NAME + DELAY_HEADERS_TYPE + DELAY_EXCHANGE_NAME;
    public static final String DELAY_HEADERS_QUEUE = DELAY_NAME + DELAY_HEADERS_TYPE + DELAY_QUEUE_NAME;
    public static final String DELAY_HEADERS_ROUTING = DELAY_NAME + DELAY_HEADERS_TYPE + DELAY_ROUTING_NAME;

}
