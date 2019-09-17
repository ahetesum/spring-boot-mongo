package com.example.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMongoCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port+"/rest/employee";
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllEmployees() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getall",
       HttpMethod.GET, entity, String.class);  
       System.out.println(response.getBody());
       assertEquals(HttpStatus.OK, response.getStatusCode());
   }
    
    

    @Test
    public void testGetEmployeeById() {
        Employee employee = restTemplate.getForObject(getRootUrl() + "/getbyid/1", Employee.class);
        System.out.println(employee.getName());
        assertEquals("Subhas Kumar", employee.getName());
    }
    
    

    @Test
    public void testCreateEmployee() {
		Employee employee = new Employee(101,"Monju R","Technical Associate",65000d);
		List<Employee> listOfEmp= new ArrayList<Employee>();
		listOfEmp.add(employee);
        ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/create", listOfEmp, String.class);
        System.out.println(postResponse.getBody());
        assertEquals("Employee records created.", postResponse.getBody());
    }

}
