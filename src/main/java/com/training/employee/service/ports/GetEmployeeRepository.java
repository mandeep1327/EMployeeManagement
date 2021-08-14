package com.training.employee.service.ports;


import com.training.employee.service.model.Employee;

import java.util.List;

/**
 * Interface for outgoing call to the repository
 */
public interface GetEmployeeRepository {

	 List<Employee>  getEmployees();
	
}
