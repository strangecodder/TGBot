package com.backendservice.services;

import com.backendservice.databases.backenddb.entities.State;
import com.backendservice.databases.backenddb.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private StateRepository stateRepository;

    //@Transactional(transactionManager = "backendTransactionManager")
    public void saveAnother(){
        Optional<State> optional = stateRepository.findById(1);

        State state = new State();
        state.setId(1);
        state.setValue("lll");
        stateRepository.save(state);
    }
}
