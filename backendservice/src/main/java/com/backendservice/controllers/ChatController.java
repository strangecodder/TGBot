package com.backendservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/api/chats")
@Slf4j
public class ChatController {

    @GetMapping("/")
    public String getAllChats(){
        return "AllChats";
    }

    @GetMapping("/chat?=")
    public String getChat(){
        return "Chat";
    }

    @GetMapping("/chat?=/messageslog")
    public String getMessages(){
        return "Messages";
    }

    @GetMapping("/chats?=/users")
    public String getAllUsers(){
        return "Users";
    }
}
