package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.app.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer> {

	@Query(value = "{ name : ?0}")
	Optional<Employee> searchEmployeeByName(String text);

}
