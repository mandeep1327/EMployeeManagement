package com.training.employee.inbound.rest.dto;

public class EmployeeDTO {
    private String empName;
    private String parent;
    int employeeId;

    public EmployeeDTO(){

    }
    public EmployeeDTO(String empName, String parent) {
        this.empName = empName;
        this.parent = parent;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
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
