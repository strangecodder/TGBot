package com.backendservice.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller("/api")
@Slf4j
public class UserController {

    @GetMapping("/users")
    public String getUsers(){
        return "AllUsers";
    }

    @GetMapping("/users/actions")
    public String getAllUserActions(){
        return "AllUserActions";
    }

    @GetMapping("/user?=")
    public String getUser(){
        return "User";
    }

    @GetMapping("/user?=/actions")
    public String getUserActions(){
        return "UserActions";
    }

    @GetMapping("/user?=/chats")
    public String getUserChats(){
        return "UserChats";
    }

    @GetMapping("/user?=/chat?=")
    public String getCurrentChat(){
        return "CurrentChat";
    }

    @PutMapping("/user?=/chat?=")
    public String putCurrentChat(){
        return "ResultOfPut";
    }
}
