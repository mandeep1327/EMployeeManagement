package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetEmployeeApiDelegateImpl implements GetEmployeeApiDelegate {

	private final GetEmployeeService service;
	private final RestMapper mapper;
	public GetEmployeeApiDelegateImpl(GetEmployeeService service,RestMapper mapper)
	{
		this.mapper=mapper;
		this.service = service;
	}

	public  ResponseEntity<List<EmployeeDTO>> getEmployees(String name) {
		EmployeeDTO inputDTO=new EmployeeDTO();
		inputDTO.setEmpName(name);
		List<Employee> employees=service.findByName(inputDTO);
		List<EmployeeDTO> response= mapper.employeeModelToDto(employees);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
