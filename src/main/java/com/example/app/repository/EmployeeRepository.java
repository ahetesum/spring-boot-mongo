package com.example.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer> {

}
