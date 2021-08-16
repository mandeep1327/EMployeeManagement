package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.service.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface AddEmployeeApiDelegate {


    @PostMapping("/addEmployee/{parent}/{empName}")
    @ResponseBody
    public ResponseEntity<EmployeeDTO> addEmployee(@PathVariable String parent, @PathVariable  String empName) ;

}
