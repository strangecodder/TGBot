package com.botservice.kafka.producer;

import com.botservice.utils.UpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, Update> kafkaTemplate;

    public void sendMessage(String topicName, Update update){
        kafkaTemplate.send(topicName,update);
    }
}
