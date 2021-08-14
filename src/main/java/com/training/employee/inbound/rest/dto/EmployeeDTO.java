package com.training.employee.inbound.rest.dto;

public class EmployeeDTO {
    private String empName;
    private String parent;

    public EmployeeDTO(){

    }
    public EmployeeDTO(String empName, String parent) {
        this.empName = empName;
        this.parent = parent;
    }

    public String getEmpName() {
        return empName;
    }

    public String getParent() {
        return parent;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", nameOfAdmin='" + parent + '\'' +
                '}';
    }
}
