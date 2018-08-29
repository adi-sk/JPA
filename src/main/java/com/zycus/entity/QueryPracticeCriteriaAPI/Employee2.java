package com.zycus.entity.QueryPracticeCriteriaAPI;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee2 {
	@Id
	private int empNo;

	private String name;
	private int salary;

	@ManyToOne
	@JoinColumn(name = "deptno")
	private Department2 department;

	public Employee2() {

	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department2 getDepartment() {
		return department;
	}

	public void setDepartment(Department2 department) {
		this.department = department;
	}

}
