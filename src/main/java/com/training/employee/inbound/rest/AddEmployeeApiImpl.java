package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.inbound.rest.dto.EmployeeResponseDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class AddEmployeeApiImpl implements AddEmployeeApi {

	private AddEmployeeService service;
	private final RestMapper mapper;
	public AddEmployeeApiImpl(AddEmployeeService service, RestMapper mapper)
	{
		this.service = service;
		this.mapper=mapper;
	}

	public ResponseEntity<EmployeeResponseDTO> addEmployee(EmployeeDTO inputDTO) {
		Employee resp=service.addEmployees(inputDTO);
		return new ResponseEntity<>(mapper.createEmployeeModelToDto(resp),HttpStatus.OK);
	}
}
