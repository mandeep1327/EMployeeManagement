package com.training.employee.inbound.rest;

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

	@MockBean
	private AddEmployeeService mockService;


	private AddEmployeeApiDelegate delegate;



	@Before
	public void setUp() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee admin=new Employee("Admin",null);
		Employee instructor1 = new Employee("I1", admin);
		employees.add(instructor1);
		employees.add(admin);
		employees.add(new Employee("I2",admin));
		employees.add(new Employee("I3",instructor1));
		delegate = new AddEmployeeApiDelegateImpl(mockService);
	}

	@Test
	public void addEmployeeIsOk() throws Exception {

		ResponseEntity response = delegate.addEmployee("Instructor4","mandeep");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
