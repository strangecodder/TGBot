package com.backendservice.databases.backenddb.repositories;

import com.backendservice.databases.backenddb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User> {
}
