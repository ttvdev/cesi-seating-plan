package com.cesi.seatingplan.repository;

import com.cesi.seatingplan.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
    @Query(value = "SELECT * FROM OFFICE WHERE FREE = 1", nativeQuery = true)
    Office findByFree();
    @Query(value = "SELECT * FROM OFFICE WHERE FREE = 1 LIMIT 1", nativeQuery = true)
    Office findFirstByFree();
}
