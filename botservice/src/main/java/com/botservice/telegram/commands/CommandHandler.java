package com.botservice.telegram.commands;

import com.botservice.utils.CommandConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class CommandHandler {

    private final Map<String,Command> commands;

    public CommandHandler(@Autowired StartCommand startCommand){
        this.commands = Map.of(
                "/start",startCommand
        );
    }

    public SendMessage handleCommands(Update update){
        String messageText = update.getMessage().getText();
        String command = messageText.split(" ")[0];
        long chatId = update.getMessage().getChatId();

        var commandHandler = commands.get(command);
        if(!Objects.equals(commandHandler,null)){
            return commandHandler.apply(update);
        }else {
            return new SendMessage(String.valueOf(chatId), CommandConsts.UNKNOWN_COMMAND);
        }
    }
}
