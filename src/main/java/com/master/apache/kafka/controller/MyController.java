package com.master.apache.kafka.controller;

import com.master.apache.kafka.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class MyController {



    private  KafkaTemplate<String, Object> kafkaTemplate;

    public MyController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopics() {
        this.kafkaTemplate.send("users","Hello");
    }
    @GetMapping(value = "/user")
    public void sendMessageToKafkaTopic() {
        this.kafkaTemplate.send("users", new User(1,"Murad","Mammadli"));
    }

}
