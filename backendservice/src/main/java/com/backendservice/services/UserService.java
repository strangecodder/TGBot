package com.backendservice.services;

import com.backendservice.databases.backenddb.entities.Employee;
import com.backendservice.databases.backenddb.entities.State;
import com.backendservice.databases.backenddb.repositories.EmployeeRepository;
import com.backendservice.databases.backenddb.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    //@Transactional(transactionManager = "backendTransactionManager")
    // ТЕСТОВЫЙ МЕТОД ДЛЯ ПРОВЕРКИ БД
    public void saveAnother(){
        Optional<State> optional = stateRepository.findById(1);

        State state = new State();
        state.setId(1);
        state.setValue("lll");
        stateRepository.save(state);
    }

/*    public ResponseEntity<HttpStatus> createEmployee(EmployeeDTO employeeDTO){

    }*/

    public ResponseEntity<Employee> getEmployeeByTgId(long tgId){
        if(!employeeRepository.existsById(tgId)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeRepository.findEmployeeById(tgId),HttpStatus.OK);
    }
}
