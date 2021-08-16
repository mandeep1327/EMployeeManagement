package com.training.employee.inbound.rest.dto;

public class EmployeeDTO {
    private String empName;
    private String parentId;

    public EmployeeDTO(){

    }
    public EmployeeDTO(String empName, String parentId) {
        this.empName = empName;
        this.parentId = parentId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", nameOfAdmin='" + parentId + '\'' +
                '}';
    }
}
