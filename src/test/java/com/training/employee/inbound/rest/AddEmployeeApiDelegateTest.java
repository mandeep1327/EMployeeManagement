package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
public class AddEmployeeApiDelegateTest {
	private final int EMPLOYEEID = 0;
	@MockBean
	private AddEmployeeService mockService;
	@MockBean
	private  RestMapper mapper;

	private AddEmployeeApiDelegate delegate;



	@Before
	public void setUp() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee admin=new Employee("admin",null);
		Employee instructor1 = new Employee("I1", admin);
		employees.add(instructor1);
		employees.add(admin);
		delegate = new AddEmployeeApiDelegateImpl(mockService,mapper);
	}

	@Test
	public void addEmployeeIsOk() throws Exception {

		ResponseEntity<EmployeeDTO> response = delegate.addEmployee("admin","I1");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
