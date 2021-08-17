package com.training.employee.outbound.repository;

import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddEmployeeRepositoryImpl implements AddEmployeeRepository {

	List<Employee> employees;
	AddEmployeeRepositoryImpl(List<Employee> employees){
		this.employees=employees;
	}

	@Override
	public  Employee addEmployee(Employee emp) {
		employees.add(emp);
		return emp;
	}


}
