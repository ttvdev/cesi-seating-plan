package com.cesi.seatingplan.repository;

import com.cesi.seatingplan.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}
