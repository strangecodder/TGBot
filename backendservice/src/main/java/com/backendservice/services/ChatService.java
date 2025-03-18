package com.backendservice.services;

//import jakarta.transaction.Transactional;
import com.backendservice.databases.backenddb.entities.State;
import com.backendservice.databases.backenddb.repositories.StateRepository;
import com.backendservice.databases.logdb.entities.Tag;
import com.backendservice.databases.logdb.repositories.TagRepository;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ChatService {
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private  TagRepository tagRepository;

    @Autowired
    private  StateRepository stateRepository;

    @Transactional(transactionManager = "logTransactionManager")
    public void saveExample(){
        //log.info(ApplicationContext.FACTORY_BEAN_PREFIX);
        Tag tag = new Tag();
        tag.setValue("#example");
        tagRepository.save(tag);
    }
}
