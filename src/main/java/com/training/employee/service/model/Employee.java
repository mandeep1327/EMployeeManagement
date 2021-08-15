package com.training.employee.service.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
	private String empName;
	private Employee parent;
	private String relation;
	public  Employee(String empName,Employee parent){
		this.empName=empName;
		this.parent=parent;
	}
	public  Employee(){
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Employee getParent() {
		return parent;
	}

	public void setParent(Employee parent) {
		this.parent = parent;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return empName.equalsIgnoreCase(employee.empName);
	}

	@Override
	public String toString() {
		return "Employee{" +
				"empName='" + empName + '\'' +
				", parent=" + (parent==null?"null":parent.getEmpName()) +
				'}';
	}

}
