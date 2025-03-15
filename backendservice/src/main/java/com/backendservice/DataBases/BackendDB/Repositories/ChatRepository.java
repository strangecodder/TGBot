package com.backendservice.DataBases.BackendDB.Repositories;

import com.backendservice.DataBases.BackendDB.Entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Integer, Chat> {
}
