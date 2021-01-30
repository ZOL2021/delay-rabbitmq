package com.zlbteam.controller;

import com.zlbteam.publish.DelayRabbitmqPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class DelayRabbitmqController {

    @Autowired
    DelayRabbitmqPublish delayRabbitmqPublish;

    @RequestMapping(value = "/direct")
    public String direct(){
        Map<String, String> msg = new HashMap<>();
        msg.put("direct", "msg:direct");
        delayRabbitmqPublish.sendDirectMessage(msg);
        return "direct";
    }

    @RequestMapping(value = "/fanout")
    public String fanout(){
        Map<String, String> msg = new HashMap<>();
        msg.put("fanout", "msg:fanout");
        delayRabbitmqPublish.sendFanoutMessage(msg);
        return "fanout";
    }

    @RequestMapping(value = "/topic")
    public String topic(String rout){
        Map<String, String> msg = new HashMap<>();
        msg.put("topic", "msg:topic");
        delayRabbitmqPublish.sendTopicMessage("." + rout, msg);
        return "topic";
    }
}
