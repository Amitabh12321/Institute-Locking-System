package com.example.InstituteLockingSystem.repository;

import com.example.InstituteLockingSystem.entity.UniversityLockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityLockStatusRepository  extends JpaRepository<UniversityLockStatus,Long> {

    boolean existsByAisheCode(String aisheCode);
}
