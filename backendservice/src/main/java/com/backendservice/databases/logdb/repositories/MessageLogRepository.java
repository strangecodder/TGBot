package com.backendservice.databases.logdb.repositories;

import com.backendservice.databases.logdb.entities.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Integer> {
}
