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
import java.util.Map;
import java.util.Random;


/**
 * Implementation of the business logic interface
 */
@Service
public class AddEmployeeServiceImpl implements AddEmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddEmployeeServiceImpl.class);

    private final AddEmployeeRepository repository;
    List<Employee> employees;
    Map<String,Integer> employeeIndex;


    public AddEmployeeServiceImpl(AddEmployeeRepository repository, List<Employee> employees, Map<String,Integer> employeeIndex) {
        this.employees = employees;
        this.repository = repository;
        this.employeeIndex=employeeIndex;
    }

    @Override
    public Employee addEmployees(EmployeeDTO inputDTO) {
        Integer currentIndex = employeeIndex.get(inputDTO.getParentId());
        if(null==currentIndex){
            throw new NotFoundException("Parent not found, id: " + currentIndex);
        }
        Employee employee = employees.get(currentIndex);
        Employee subordinate = new Employee(inputDTO.getEmpName(), employee);
        subordinate.setEmployeeId(String.valueOf(getNextId()));
        employee.addSubordinate(subordinate);
        Employee savedEmployee=repository.addEmployee(subordinate);
        employeeIndex.put(String.valueOf(subordinate.getEmployeeId()), currentIndex + 1);
        employees.stream().forEach(System.out::println);
        return savedEmployee;
    }

    private int getNextId(){
        Random rand = new Random();
        int nextId= rand.nextInt(1000);
        return nextId;
    }
}
