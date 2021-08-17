package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeDTO;
import com.training.employee.inbound.rest.dto.EmployeeResponseDTO;
import com.training.employee.inbound.rest.dto.ErrorMessageDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value = "Employee", description = "Add Employee API")
@Controller
public interface AddEmployeeApi {


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee  Added.", response = EmployeeResponseDTO.class),
            @ApiResponse(code = 404, message = "Employee Not Added.", response = ErrorMessageDTO.class)})

    @RequestMapping(value = "/v1/addEmployee/",
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody EmployeeDTO input);

}
