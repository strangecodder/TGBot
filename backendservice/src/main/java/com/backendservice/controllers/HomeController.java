package com.backendservice.controllers;

import com.backendservice.databases.backenddb.entities.Chat;
import com.backendservice.databases.backenddb.entities.State;
import com.backendservice.databases.backenddb.repositories.ChatRepository;
import com.backendservice.databases.backenddb.repositories.StateRepository;
import com.backendservice.databases.logdb.entities.BaseTable;
import com.backendservice.databases.logdb.entities.Tag;
import com.backendservice.databases.logdb.repositories.BaseTableRepository;
import com.backendservice.databases.logdb.repositories.TagRepository;
import com.backendservice.services.ChatService;
import com.backendservice.services.KafkaService;
import com.backendservice.services.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@Slf4j
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private BaseTableRepository baseTableRepository;

    @GetMapping("/")
    public String getAllChat(){
        chatService.saveExample();
        return "OK";
    }

    @GetMapping("/ll")
    public String jj(){
        userService.saveAnother();
        return "ok";
    }

    @GetMapping("/kakfka")
    public String l(){
        kafkaService.sendMessage("Hello, Spring fucker");
        return "ok";
    }


}
