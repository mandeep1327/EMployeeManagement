package com.training.employee.service.application;

import com.training.employee.config.EmployeeRepositoryMock;
import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeRepository;
import com.training.employee.service.ports.GetEmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class GetEmployeeServiceTest {

    private GetEmployeeService service;

    @MockBean
    private GetEmployeeRepository employeeRepository;
    EmployeeRepositoryMock mock=new EmployeeRepositoryMock();

    private  List<Employee> employees=new ArrayList<>();

    @Before
    public void setup() {
        service = new GetEmployeeServiceImpl(employeeRepository);
        EmployeeRepositoryMock empMockData=new EmployeeRepositoryMock();
        employees=empMockData.getEmployees();

    }

    @Test
    public void getEmployees() {
        employees =mock.getEmployees();
        EmployeeDTO input=new EmployeeDTO();
        input.setEmpName("I1");
        when(employeeRepository.getEmployees()).thenReturn(employees);
        List<Employee> employees = service.findByName(input);

        assertEquals(1,employees.size());
        assertEquals("I1",employees.get(0).getEmpName());
    }
}