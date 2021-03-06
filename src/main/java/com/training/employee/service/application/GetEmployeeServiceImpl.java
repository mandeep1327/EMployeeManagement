package com.training.employee.service.application;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.exception.NotFoundException;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeRepository;
import com.training.employee.service.ports.GetEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Implementation of the business logic interface
 */
@Service
public class GetEmployeeServiceImpl implements GetEmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetEmployeeServiceImpl.class);

	private final GetEmployeeRepository repository;
	Map<String,Integer> employeeIndex;
	public GetEmployeeServiceImpl(GetEmployeeRepository repository,Map<String,Integer> employeeIndex) {

		this.repository = repository;
		this.employeeIndex=employeeIndex;
	}

	@Override
	public List<Employee> findById(EmployeeDTO inputDTO) {
		int index=employeeIndex.get(String.valueOf(inputDTO.getParentId()));
		List<Employee>  employees=repository.getEmployees();
		List<Employee> response=employees.get(index).getSubordinates();
		if(response.size()==0){
			throw new NotFoundException("Subordinate not found for id, " + inputDTO.getParentId()+ " : Please add first");
		}
		return response;
	}



}
