package com.example.InstituteLockingSystem.repository;

import com.example.InstituteLockingSystem.entity.StandaloneLockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandaloneLockStatusRepository extends JpaRepository<StandaloneLockStatus,Long> {
    boolean existsByAisheCode(String aisheCode);
}
