package com.backendservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/api")
@Slf4j
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "OK";
    }
}
