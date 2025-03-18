package com.backendservice.databases.backenddb.repositories;

import com.backendservice.databases.backenddb.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {
}
