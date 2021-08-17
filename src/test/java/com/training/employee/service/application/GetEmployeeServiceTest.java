
package com.training.employee.service.application;

import com.training.employee.config.EmployeeRepositoryMock;
import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.GetEmployeeRepository;
import com.training.employee.service.ports.GetEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GetEmployeeServiceTest {

    private GetEmployeeService service;

    @MockBean
    private GetEmployeeRepository employeeRepository;
    EmployeeRepositoryMock mock=new EmployeeRepositoryMock();

    private  List<Employee> employees=new ArrayList<>();

    @BeforeEach
    public void setup() {
        service = new GetEmployeeServiceImpl(employeeRepository);
        EmployeeRepositoryMock empMockData=new EmployeeRepositoryMock();
        employees=empMockData.getEmployees();

    }

    @Test
    public void getEmployees() {
        employees =mock.getEmployees();
        EmployeeDTO input=new EmployeeDTO();
        input.setParentId("1");
        when(employeeRepository.getEmployees()).thenReturn(employees);
       // List<Employee> employees = service.findById(input);

        //  assertEquals(1,employees.size());
        // assertEquals("I1",employees.get(1).getEmpName());
    }
}
