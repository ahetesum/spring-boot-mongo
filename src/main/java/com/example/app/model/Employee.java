package com.example.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection = "Employee")
@Component
public class Employee 
{

	@Id
	private int id;
	private String name;
	private String designation;
	private Double salary;
	
	
	
	public Employee() {
		super();
	}



	public Employee(int id, String name,String designation ,double salary) {
		super();
		this.id= id;
		this.name= name;
		this.designation= designation;
		this.salary= salary;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public Double getSalary() {
		return salary;
	}



	public void setSalary(Double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ",designation=\" + designation + \", salary=" + salary + "]";
	}
	
	
}
