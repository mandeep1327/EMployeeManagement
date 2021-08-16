package com.training.employee.outbound.repository;

import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetEmployeeRepositoryImpl implements GetEmployeeRepository {

	private List<Employee> employees;
	GetEmployeeRepositoryImpl(List<Employee> employees){
		this.employees=employees;
	}

	@Override
	public  List<Employee> getEmployees() {

		return employees;
	}




}
