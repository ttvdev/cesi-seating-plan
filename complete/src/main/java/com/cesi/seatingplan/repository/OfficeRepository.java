package com.cesi.seatingplan.repository;

import com.cesi.seatingplan.entity.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Integer> {

}
