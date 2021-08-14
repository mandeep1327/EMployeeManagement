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

	private GetEmployeeService service;
    private RestMapper mapper;
	public GetEmployeeApiDelegateImpl(GetEmployeeService service,RestMapper mapper)
	{
		this.mapper=mapper;
		this.service = service;
	}

	public  ResponseEntity<List<EmployeeDTO>> getEmployees(String name) {
	    EmployeeDTO inputDTO=new EmployeeDTO();
		inputDTO.setEmpName(name);
		List<Employee> employees=service.getEmployees(inputDTO);
		List<EmployeeDTO> response= mapper.employeeModelToDto(employees);
		System.out.println("Employee List->"+response.size());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
