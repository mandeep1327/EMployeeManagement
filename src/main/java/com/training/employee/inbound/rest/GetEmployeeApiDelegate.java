package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public interface GetEmployeeApiDelegate {


    @GetMapping("/getEmployees/{id}")
    @ResponseBody
    public ResponseEntity<List<EmployeeDTO>> getEmployees(@PathVariable String id) ;

}
