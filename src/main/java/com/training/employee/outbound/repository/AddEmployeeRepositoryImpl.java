package com.training.employee.outbound.repository;

import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddEmployeeRepositoryImpl implements AddEmployeeRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddEmployeeRepositoryImpl.class);

	List<Employee> employees;
	AddEmployeeRepositoryImpl(List<Employee> employees){
		this.employees=employees;
	}

	@Override
	public  void addEmployee(Employee emp) {
		employees.add(emp);
		//employees.stream().forEach(value->LOGGER.info("",value));
	}


}
