package com.botservice.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bot")
@Data
@PropertySource("classpath:application.yml")
public class BotProperties {

    @Value("${bot.name}")
    private String name;

    @Value("${bot}")
    private String token;
}
