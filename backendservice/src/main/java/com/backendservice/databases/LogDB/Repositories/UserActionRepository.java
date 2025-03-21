package com.backendservice.databases.LogDB.Repositories;

import com.backendservice.databases.LogDB.Entities.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionRepository extends JpaRepository<Integer, UserAction> {
}
