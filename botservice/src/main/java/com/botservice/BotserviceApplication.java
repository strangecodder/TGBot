package com.botservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BotserviceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BotserviceApplication.class, args);
        SpringApplication springApplication = new SpringApplication(BotserviceApplication.class);
        springApplication.setDefaultProperties(Collections.singletonMap(
                "server.port",8081
        ));
        springApplication.run();
    }

}
