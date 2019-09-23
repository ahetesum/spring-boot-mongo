package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.app.model.Employee;
import com.example.app.repository.EmployeeRepository;
import com.example.app.service.EmployeeService;
import com.example.app.service.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceUnitTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImpl();

	private Employee emp1 = new Employee(1, "Subhas Kumar", "Technical Associate", 60000d);

	@BeforeEach
	void setMockOutput() {

		when(employeeRepository.findById(1)).thenReturn(Optional.of(emp1));
	}

	@Test
	@DisplayName("Employee Service GetAll ")
	public void getAll() {
		System.out.println(employeeService.findEmployeeById(1).get().getId());

		assertEquals(emp1.getId(), employeeService.findEmployeeById(1).get().getId());

	}
}
