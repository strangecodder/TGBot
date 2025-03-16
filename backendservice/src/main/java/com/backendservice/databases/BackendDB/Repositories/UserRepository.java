package com.backendservice.databases.BackendDB.Repositories;

import com.backendservice.databases.BackendDB.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User> {
}
