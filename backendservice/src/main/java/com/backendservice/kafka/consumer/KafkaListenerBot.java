package com.backendservice.kafka.consumer;

import com.backendservice.util.UpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.telegram.telegrambots.meta.api.objects.Update;

@Configuration
@Slf4j
public class KafkaListenerBot {

    @KafkaListener(topics = "bot-to-back", groupId = "group1")
    void listener(Update update){
        log.info("Received message [{}] in group1",update.getMessage());
    }


}
