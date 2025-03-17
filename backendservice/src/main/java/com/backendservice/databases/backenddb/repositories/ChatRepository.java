package com.backendservice.databases.backenddb.repositories;

import com.backendservice.databases.backenddb.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Integer, Chat> {
}
