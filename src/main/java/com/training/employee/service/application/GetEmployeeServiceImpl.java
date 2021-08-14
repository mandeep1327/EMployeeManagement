package com.training.employee.service.application;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeRepository;
import com.training.employee.service.ports.GetEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation of the business logic interface
 */
@Service
public class GetEmployeeServiceImpl implements GetEmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetEmployeeServiceImpl.class);

	private final GetEmployeeRepository repository;

	public GetEmployeeServiceImpl(GetEmployeeRepository repository) {

		this.repository = repository;
	}

	@Override
	public List<Employee> getEmployees(EmployeeDTO inputDTO) {
		System.out.println("GetEmployee="+inputDTO.getEmpName());
		List<Employee>  employees=repository.getEmployees();
		List<Employee> getEmployees=employees.stream().filter(userEntity -> userEntity.getParent() != null)
				.filter(emp->emp.getParent().getEmpName().equals(inputDTO.getEmpName()))
				.collect(Collectors.toList());
			//	.forEach(System.out::println);
          return getEmployees;
	}



}
