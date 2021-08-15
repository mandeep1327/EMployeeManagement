package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestMapper {


	public List<EmployeeDTO> employeeModelToDto(List<Employee> employees) {
		List<EmployeeDTO> response=  employees.stream().filter(userEntity -> userEntity.getParent() != null)
				.map(emp -> new EmployeeDTO(emp.getEmpName(), emp.getParent().getEmpName()))
				.collect(Collectors.toList());
		return response;
	}
}