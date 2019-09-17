package com.example.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.app.model.Employee;


public interface EmployeeService {

	public void createEmployee(List<Employee> employee);

	public Collection<Employee> getAllEmployees();

	public Optional<Employee> findEmployeeById(int id);

	public void deleteEmployeeById(int id);

	public void updateEmployee(Employee employee);

	public void deleteAllEmployees();
	
}
