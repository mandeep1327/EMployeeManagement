package com.training.employee.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface AddEmployeeApiDelegate {


    @PostMapping("/addEmployee/{parent}/{empName}")
    @ResponseBody
    public ResponseEntity addEmployee(@PathVariable String parent,@PathVariable  String empName) ;

}
