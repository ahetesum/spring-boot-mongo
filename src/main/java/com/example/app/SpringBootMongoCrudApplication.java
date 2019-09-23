package com.example.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.app.model.Employee;
import com.example.app.repository.EmployeeRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class SpringBootMongoCrudApplication implements CommandLineRunner {

	@Autowired private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.deleteAll();
		
		Employee emp1 = new Employee(1,"Subhas Kumar","Technical Associate",60000d);
		Employee emp2 = new Employee(2,"Krisna Prashad","Product Manager",64000d);
		Employee emp3 = new Employee(3,"Nourin Cahar","Technical Lead",52000d);
		Employee emp4 = new Employee(4,"Abhishek Das","Developer",78000d);
		
		List<Employee> employeeList= new ArrayList<Employee>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);

		employeeRepository.insert(employeeList);
	

	}

}
