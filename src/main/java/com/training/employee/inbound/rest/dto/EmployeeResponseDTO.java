package com.training.employee.inbound.rest.dto;

public class EmployeeResponseDTO {
    private String empName;
    private String parentName;

    public EmployeeResponseDTO(){

    }
    public EmployeeResponseDTO(String empName, String parentName) {
        this.empName = empName;
        this.parentName = parentName;
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


    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", nameOfAdmin='" + parentName + '\'' +
                '}';
    }
}
