package com.training.employee.inbound.rest;

import com.training.employee.inbound.rest.dto.EmployeeResponseDTO;
import com.training.employee.inbound.rest.dto.ErrorMessageDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "Employee", description = "Get Employee API")
@Controller
public interface GetEmployeeApi {


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee found.", response = EmployeeResponseDTO.class),
            @ApiResponse(code = 404, message = "Employee Not found.", response = ErrorMessageDTO.class)})

    @RequestMapping(value = "/v1/getEmployees",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployees( @RequestParam(value="id") String id) ;

}
