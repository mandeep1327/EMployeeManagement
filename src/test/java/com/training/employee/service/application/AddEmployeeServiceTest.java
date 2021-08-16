package com.training.employee.service.application;

import com.training.employee.config.EmployeeRepositoryMock;
import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeRepository;
import com.training.employee.service.ports.AddEmployeeService;
import com.training.employee.service.ports.GetEmployeeRepository;
import com.training.employee.service.ports.GetEmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AddEmployeeServiceTest {
    private final int EMPLOYEEID = 1;
    private AddEmployeeService service;

    @MockBean
    private AddEmployeeRepository employeeRepository;

    private  List<Employee> employees ;
    @Before
    public void setup() {
        EmployeeRepositoryMock empMockData=new EmployeeRepositoryMock();
        employees=empMockData.getEmployees();
        employees.get(0).setEmployeeId(EMPLOYEEID);
        service = new AddEmployeeServiceImpl(employeeRepository,employees);

    }


    @Test
    public void addEmployee() {
        Employee emp=new Employee();
        emp.setEmployeeId(EMPLOYEEID);
        EmployeeDTO input=new EmployeeDTO();
        input.setEmpName("I1");
        input.setParent("admin");
        doNothing().when(employeeRepository).addEmployee(any());
         service.addEmployees(input);
        assertEquals(1,employees.size());
    }

}