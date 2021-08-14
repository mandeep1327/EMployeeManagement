package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.ports.AddEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class AddEmployeeApiDelegateImpl implements AddEmployeeApiDelegate {

	private AddEmployeeService service;

	public AddEmployeeApiDelegateImpl(AddEmployeeService service)
	{
		this.service = service;
	}

	public ResponseEntity addEmployee( String parent,String empName) {
	    EmployeeDTO inputDTO=new EmployeeDTO();
		inputDTO.setParent(parent);
		inputDTO.setEmpName(empName);
		service.addEmployees(inputDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
