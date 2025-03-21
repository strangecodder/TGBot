package com.backendservice.databases.LogDB.Repositories;

import com.backendservice.databases.LogDB.Entities.BaseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTableRepository extends JpaRepository<Integer, BaseTable> {
}
