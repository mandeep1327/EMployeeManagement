package com.training.employee.config;

import com.training.employee.service.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class EmployeeRepositoryMock {
	private List<Employee> employees= new ArrayList<Employee>();
	private Map<String,Integer> employeeIndex=new HashMap<>();

	@Bean
	public  List<Employee> getEmployees() {
		if(employees.isEmpty()){
			employees=getEmployeeData();
		}
		return employees;
	}

	public Employee getAdmin(){
		Employee admin = new Employee("admin", null);
		admin.setEmployeeId("0");
		return admin;
	}
	private List<Employee> getEmployeeData(){
		Employee root=getAdmin();
		employees.add(root);
		employeeIndex.put(root.getEmployeeId(),0);
		return employees;
	}
	@Bean
	public Map<String, Integer> getEmployeeIndex() {
		return employeeIndex;
	}
}
