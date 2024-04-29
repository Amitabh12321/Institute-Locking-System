package com.example.InstituteLockingSystem.repository;

import com.example.InstituteLockingSystem.entity.CollegeLockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeLockStatusRepository  extends JpaRepository<CollegeLockStatus,Long> {
    boolean existsByAisheCode(String aisheCode);
}
