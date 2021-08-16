package com.training.employee.service.ports;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;

/**
 * Interface for business logic
 */
public interface AddEmployeeService {

	Employee addEmployees(EmployeeDTO inputDTO);

}