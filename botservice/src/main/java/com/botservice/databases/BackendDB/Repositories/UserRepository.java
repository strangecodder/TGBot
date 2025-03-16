package com.botservice.databases.BackendDB.Repositories;

import com.botservice.databases.BackendDB.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User> {
}
