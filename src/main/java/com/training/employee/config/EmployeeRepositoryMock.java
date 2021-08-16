package com.training.employee.config;

import com.training.employee.service.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EmployeeRepositoryMock {
	private List<Employee> employees= new ArrayList<Employee>();

	@Bean
	public  List<Employee> getEmployees() {
		if(employees.isEmpty()){
			employees=getMockEmployees();
		}
		return employees;
	}

	public Employee getAdmin(){
		return new Employee("admin",null);
	}
	private List<Employee> getMockEmployees(){
		Employee root=getAdmin();
		employees.add(root);
		return employees;
	}


}
