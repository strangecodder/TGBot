package com.backendservice.services;

import com.backendservice.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    //todo: логику отправки сообщений
    //todo: отправка DTO

    @Autowired
    private KafkaSender kafkaSender;

    public void sendMessage(String message){
        kafkaSender.sendMessage(message,"topic1");
    }
}
