package com.training.employee.service.ports;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;

import java.util.List;

/**
 * Interface for business logic
 */
public interface GetEmployeeService {

	List<Employee> findById(EmployeeDTO inputDTO);

}