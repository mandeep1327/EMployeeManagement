package com.training.employee.service.ports;

import com.training.employee.inbound.rest.dto.EmployeeDTO;

/**
 * Interface for business logic
 */
public interface AddEmployeeService {

	void addEmployees(EmployeeDTO inputDTO);

}