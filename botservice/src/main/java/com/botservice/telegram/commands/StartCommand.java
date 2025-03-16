package com.botservice.telegram.commands;

import com.botservice.utils.CommandConsts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command{

    @Override
    public SendMessage apply(Update update){
        long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(CommandConsts.START_MESSAGE);

        addKeyboard(sendMessage);
        return sendMessage;
    }

    private void addKeyboard(SendMessage sendMessage){

    }
}
