package com.backendservice.DataBases.LogDB.Repositories;

import com.backendservice.DataBases.LogDB.Entities.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionRepository extends JpaRepository<Integer, UserAction> {
}
