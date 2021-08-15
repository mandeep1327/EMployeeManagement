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


	private List<Employee> getMockEmployees(){
		Employee admin=new Employee("Admin",null);
		Employee instructor1 = new Employee("I1", admin);
		employees.add(instructor1);
		employees.add(admin);
		employees.add(new Employee("I2",admin));
		employees.add(new Employee("I3",instructor1));
		return employees;
	}


}
