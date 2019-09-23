package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Employee;
import com.example.app.service.EmployeeServiceImpl;
import java.util.Collection;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping( value = "/getall")
	public Collection<Employee> getAllEmployee() {
		 logger.info("Getting all employees.");
		return employeeService.getAllEmployees();
	}
	
	@GetMapping( value = "/search")
	public Optional<Employee> searchEmployee(String text) {
		 logger.error("Getting employee searching = {}.", text);
		return employeeService.searchEmployeeByName(text);
	}

	@GetMapping( value = "/getbyid/{id}")
	@Cacheable("getEmployeeWithId")
	public Optional<Employee> getEmployeeWithId(@PathVariable(value = "id") int id) {
		 logger.error("Getting employee with employee-id= {}.", id);
		return employeeService.findEmployeeById(id);
	}
	
    @PostMapping(value= "/create")
    public String create(@RequestBody List<Employee> employees) {
        logger.debug("Saving employees.");
        employeeService.createEmployee(employees);
        return "Employee records created.";
    }

	@PutMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") int id, @RequestBody Employee employee) {
		logger.debug("Updating employee with employee-id= {}.", id);
		employee.setId(id);
		employeeService.updateEmployee(employee);
		return "Employee record for employee-id= " + id + " updated.";
	}
	
	   @DeleteMapping(value= "/delete/{id}")
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting employee with employee-id= {}.", id);
	        employeeService.deleteEmployeeById(id);
	        return "Employee record for employee-id= " + id + " deleted.";
	    }
	
	    @DeleteMapping(value= "/deleteall")
	    public String deleteAll() {
	        logger.debug("Deleting all employees.");
	        employeeService.deleteAllEmployees();
	        return "All employee records deleted.";
	    }
}
