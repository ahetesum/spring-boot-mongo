package com.example.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Employee;
import com.example.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void createEmployee(List<Employee> employees) {
		employeeRepository.saveAll(employees);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	
	public Optional<Employee> searchEmployeeByName(String text) {
		// TODO Auto-generated method stub
		return employeeRepository.searchEmployeeByName(text);
	}

}
