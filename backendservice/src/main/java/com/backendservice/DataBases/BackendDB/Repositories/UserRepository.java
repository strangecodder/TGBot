package com.backendservice.DataBases.BackendDB.Repositories;

import com.backendservice.DataBases.BackendDB.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User> {
}
