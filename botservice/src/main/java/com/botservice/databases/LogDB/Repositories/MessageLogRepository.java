package com.botservice.databases.LogDB.Repositories;

import com.backendservice.databases.LogDB.Entities.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends JpaRepository<Integer, MessageLog> {
}
