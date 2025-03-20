package com.botservice.services;

import com.botservice.dto.EmployeeDTO;
import com.botservice.kafka.producer.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private KafkaSender kafkaSender;

    public void sendEmployeeData(String mes){
        kafkaSender.sendMessage("bot-to-back",mes);
    }
}
