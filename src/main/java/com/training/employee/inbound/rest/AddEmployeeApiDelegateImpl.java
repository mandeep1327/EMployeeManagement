package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class AddEmployeeApiDelegateImpl implements AddEmployeeApiDelegate {

	private AddEmployeeService service;
	private final RestMapper mapper;
	public AddEmployeeApiDelegateImpl(AddEmployeeService service,RestMapper mapper)
	{
		this.service = service;
		this.mapper=mapper;
	}

	public ResponseEntity<EmployeeDTO> addEmployee( String parent,String empName) {
		EmployeeDTO inputDTO=new EmployeeDTO();
		inputDTO.setParent(parent);
		inputDTO.setEmpName(empName);
		Employee resp=service.addEmployees(inputDTO);
		return new ResponseEntity<>(mapper.createEmployeeModelToDto(resp),HttpStatus.OK);
	}
}
