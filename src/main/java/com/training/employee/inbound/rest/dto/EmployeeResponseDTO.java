package com.training.employee.inbound.rest.dto;

public class EmployeeResponseDTO {
    private String empName;
    private String parentName;
    private String employeeId;

    public EmployeeResponseDTO(){

    }
    public EmployeeResponseDTO(String empName, String parentName,String employeeId) {
        this.empName = empName;
        this.parentName = parentName;
        this.employeeId= employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", nameOfAdmin='" + parentName + '\'' +
                '}';
    }
}
