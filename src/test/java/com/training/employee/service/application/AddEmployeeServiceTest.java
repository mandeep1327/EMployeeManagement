
package com.training.employee.service.application;

import com.training.employee.config.EmployeeRepositoryMock;
import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeRepository;
import com.training.employee.service.ports.AddEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
public class AddEmployeeServiceTest {
    private final String EMPLOYEEID = "1";
    private AddEmployeeService service;

    @MockBean
    private AddEmployeeRepository employeeRepository;

    private  List<Employee> employees ;
    private Map<String,Integer> employeeIndex;

    @BeforeEach
    public void setup() {
        EmployeeRepositoryMock empMockData=new EmployeeRepositoryMock();
        employees=empMockData.getEmployees();
        employeeIndex=empMockData.getEmployeeIndex();
        System.out.println("employeeIndex="+employeeIndex.size());
        employees.get(0).setEmployeeId(EMPLOYEEID);
        service = new AddEmployeeServiceImpl(employeeRepository,employees,employeeIndex);

    }


    @Test
    public void addEmployee() {
        Employee emp=new Employee();
        emp.setEmployeeId(EMPLOYEEID);
        EmployeeDTO input=new EmployeeDTO();
        input.setEmpName("I1");
        input.setParentId("0");
     //   service.addEmployees(input);
     //   assertEquals(1,employees.size());
    }

}
