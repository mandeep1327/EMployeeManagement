
package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class GetEmployeeApiDelegateTest {

	@MockBean
	private GetEmployeeService mockService;
	private RestMapper mapper = new RestMapper();

	private GetEmployeeApiDelegate delegate;
	private List<Employee> employees = null;


	@BeforeEach
	public void setUp() {
		employees = new ArrayList<Employee>();
		Employee admin = new Employee("admin", null);
		Employee instructor1 = new Employee("I1", admin);    //get(0)
		employees.add(instructor1);
		employees.add(admin);
		when(mockService.findById(any())).thenReturn(employees);
		delegate = new GetEmployeeApiDelegateImpl(mockService, mapper);
	}

	@Test
	public void getEmployee() throws Exception {
		ResponseEntity<List<EmployeeDTO>> response = delegate.getEmployees("I1");
		List<EmployeeDTO> employees = response.getBody();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("I1", employees.get(0).getEmpName());
		assertEquals("admin", employees.get(0).getParentId());
	}

}

