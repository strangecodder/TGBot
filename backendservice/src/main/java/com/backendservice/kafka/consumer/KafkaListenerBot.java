package com.backendservice.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaListenerBot {

    @KafkaListener(topics = "bot-to-back", groupId = "group1")
    void listener(String data){
        log.info("Received message [{}] in group1",data);
    }


}
