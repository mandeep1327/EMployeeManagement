package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeResponseDTO;
import com.training.employee.service.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestMapper {


	public List<EmployeeResponseDTO> employeeModelToDto(List<Employee> employees) {
		List<EmployeeResponseDTO> response=  employees.stream().filter(userEntity -> userEntity.getParent() != null)
				.map(emp -> new EmployeeResponseDTO(emp.getEmpName(), emp.getParent().getEmpName()))
				.collect(Collectors.toList());
		return response;
	}
	public EmployeeResponseDTO createEmployeeModelToDto(Employee employee) {
		EmployeeResponseDTO response=new EmployeeResponseDTO();
		if(null!=response.getParentName()) {
			response.setParentName(response.getParentName());
		}
		response.setEmpName(employee.getEmpName());
		return response;
	}
}