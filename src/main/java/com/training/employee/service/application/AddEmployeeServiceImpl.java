package com.training.employee.service.application;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeRepository;
import com.training.employee.service.ports.AddEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Implementation of the business logic interface
 */
@Service
public class AddEmployeeServiceImpl implements AddEmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddEmployeeServiceImpl.class);

    private final AddEmployeeRepository repository;
    List<Employee> employees;

    public AddEmployeeServiceImpl(AddEmployeeRepository repository, List<Employee> employees) {
        this.employees = employees;
        this.repository = repository;
    }

    @Override
    public void addEmployees(EmployeeDTO inputDTO) {
        final Employee search = new Employee(inputDTO.getParent(), null);
        Employee parent = employees.stream().
                filter(emp -> emp.equals(search))
                .findAny().orElse(new Employee());

        search.setEmpName(inputDTO.getEmpName());
        search.setParent(parent);


        repository.addEmployee(search);
        employees.stream().forEach(System.out::println);

    }


}
