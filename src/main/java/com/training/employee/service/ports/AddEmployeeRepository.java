package com.training.employee.service.ports;

import com.training.employee.service.model.Employee;

/**
 * Interface for outgoing call to the repository
 */
public interface AddEmployeeRepository {

	 void addEmployee(Employee employee);
	
}
