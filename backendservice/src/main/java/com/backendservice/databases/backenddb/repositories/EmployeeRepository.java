package com.backendservice.databases.backenddb.repositories;

import com.backendservice.databases.backenddb.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeById(long id);
    boolean existsById(long id);
}
