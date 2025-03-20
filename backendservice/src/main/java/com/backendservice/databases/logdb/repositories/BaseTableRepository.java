package com.backendservice.databases.logdb.repositories;

import com.backendservice.databases.logdb.entities.BaseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTableRepository extends JpaRepository<BaseTable, Integer> {
}
