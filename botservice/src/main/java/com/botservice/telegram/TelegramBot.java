package com.botservice.telegram;

import com.botservice.configs.BotProperties;
import com.botservice.telegram.commands.CommandHandler;
import com.botservice.utils.CommandConsts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    public final BotProperties botProperties;

    public final CommandHandler commandHandler;

    @Override
    public String getBotUsername(){
        return botProperties.getName();
    }

    @Override
    public String getBotToken(){
        return botProperties.getToken();
    }

    @Override
    public void onUpdateReceived(Update update){
        // todo: добавить проверку на наличие пользователя в базе
        if(update.hasMessage() && update.getMessage().hasText()){
            String chatId = update.getMessage().getChatId().toString();
            if(update.getMessage().getText().startsWith("/")){
                sendMessage(commandHandler.handleCommands(update));
            }else {
                sendMessage(new SendMessage(chatId, CommandConsts.CANT_UNDERSTAND));}

        }
        //todo: дописать здесь обработку нажатия кнопок
    }


    /**Добавление кнопок в бота*/
    private void sendKeyboard(long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Выберите опцию: ");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton("Кнопка 1"));
        row.add(new KeyboardButton("Кнопка 2"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
