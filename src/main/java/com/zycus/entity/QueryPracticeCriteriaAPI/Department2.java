package com.zycus.entity.QueryPracticeCriteriaAPI;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT")
public class Department2 {

	@Id
	private int deptno;

	private String name;
	private String location;

	@OneToMany(/* mappedBy = "department", */ cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno")
	private Set<Employee2> employees;

	public Department2() {

	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee2> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee2> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + ", employees=" + employees
				+ "]";
	}

}
