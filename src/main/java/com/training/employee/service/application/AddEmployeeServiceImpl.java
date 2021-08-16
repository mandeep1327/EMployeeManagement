package com.training.employee.service.application;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.exception.NotFoundException;
import com.training.employee.service.model.Employee;
import com.training.employee.service.ports.AddEmployeeRepository;
import com.training.employee.service.ports.AddEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Implementation of the business logic interface
 */
@Service
public class AddEmployeeServiceImpl implements AddEmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddEmployeeServiceImpl.class);

    private final AddEmployeeRepository repository;
    List<Employee> employees;
    int nextId =1;
    public AddEmployeeServiceImpl(AddEmployeeRepository repository, List<Employee> employees) {
        this.employees = employees;
        this.repository = repository;
    }

    @Override
    public Employee addEmployees(EmployeeDTO inputDTO) {
        Employee search = new Employee(inputDTO.getParent(), null);
        Employee employee = employees.stream().
                filter(emp -> emp.equals(search))
                .findAny().orElse(employees.get(0));
        search.setEmpName(inputDTO.getEmpName());
        search.setParent(employee);
        search.setEmployeeId(nextId);
        repository.addEmployee(search);
        nextId++;

        return getEmployee(search.getEmployeeId());

    }

    private Employee getEmployee(int employeeId) {

        Optional<Employee> emp= employees.stream()
                .filter(empl->empl.getEmployeeId()==employeeId)
                .findFirst();
        if(!emp.isPresent()){
            throw new NotFoundException("Employee not found, id: " + employeeId);
        }
        return emp.get();
    }


}
