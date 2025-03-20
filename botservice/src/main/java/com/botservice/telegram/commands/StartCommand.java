package com.botservice.telegram.commands;

import com.botservice.dto.EmployeeDTO;
import com.botservice.services.RegistrationService;
import com.botservice.utils.CommandConsts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command{

    @Autowired
    private RegistrationService registrationService;

    @Override
    public SendMessage apply(Update update){
        long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(CommandConsts.START_MESSAGE);

        addKeyboard(sendMessage);


        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(chatId);
        registrationService.sendEmployeeData("Ввёл команду /start");
        return sendMessage;
    }

    private void addKeyboard(SendMessage sendMessage){

    }
}
