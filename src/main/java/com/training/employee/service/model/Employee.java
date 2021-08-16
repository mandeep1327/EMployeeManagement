package com.training.employee.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee implements Serializable {
	private String empName;
	private Employee parent;
	private String  employeeId;
	List<Employee> subordinates=new ArrayList<>();

	public  Employee(String empName,Employee parent){
		this.empName=empName;
		this.parent=parent;
	}
	public Employee(){

	}

	public void addSubordinate(Employee e){
		subordinates.add(e);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Employee getParent() {
		return parent;
	}


	public String getEmpName() {
		return empName;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return employeeId == employee.employeeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId='" + employeeId + '\'' +
				"empName='" + empName + '\'' +
				", parent=" + (parent==null?"null":parent.getEmpName()) +
				'}';
	}

}
