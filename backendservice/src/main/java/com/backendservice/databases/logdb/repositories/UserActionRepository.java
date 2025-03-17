package com.backendservice.databases.logdb.repositories;

import com.backendservice.databases.logdb.entities.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionRepository extends JpaRepository<Integer, UserAction> {
}
