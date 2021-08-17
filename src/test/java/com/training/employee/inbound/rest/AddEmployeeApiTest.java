package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.inbound.rest.dto.EmployeeResponseDTO;
import com.training.employee.service.ports.AddEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;


@ExtendWith(SpringExtension.class)
public class AddEmployeeApiTest {
	@MockBean
	private AddEmployeeService mockService;
	@MockBean
	private  RestMapper mapper;

	private AddEmployeeApi delegate;



	@BeforeEach
	public void setUp() {

		delegate = new AddEmployeeApiImpl(mockService,mapper);
	}

	@Test
	public void addEmployeeIsOk() throws Exception {
		EmployeeDTO input=new EmployeeDTO();
		input.setParentId("0");
		input.setEmpName("I1");
		ResponseEntity<EmployeeResponseDTO> response = delegate.addEmployee(input);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
