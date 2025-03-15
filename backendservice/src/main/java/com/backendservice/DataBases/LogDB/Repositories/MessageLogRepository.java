package com.backendservice.DataBases.LogDB.Repositories;

import com.backendservice.DataBases.LogDB.Entities.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends JpaRepository<Integer, MessageLog> {
}
