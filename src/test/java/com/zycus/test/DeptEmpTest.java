package com.zycus.test;

import org.junit.Test;

import com.zycus.dao.GenericD;
import com.zycus.entity.Department;
import com.zycus.entity.Employee;

public class DeptEmpTest {
	GenericD genericD = new GenericD();

	@Test
	public void addDep() {

		Department dept = new Department();
		dept.setDeptno(2);
		dept.setName("ITS");
		dept.setLocation("Mumbai");

		GenericD genericD = new GenericD();

		genericD.create(dept);

	}

	@Test
	public void addEmp() {
		Employee emp = new Employee();

		Department dept = genericD.fetchById(2, Department.class);

		System.out.println(dept);

		emp.setEmpNo(1005);
		emp.setName("aditya k");
		emp.setSalary(100);
		// emp.setDepartment(dept);

		dept.getEmployees().add(emp);

		genericD.update(dept);

	}

	@Test
	public void addEmp2() {
		Employee emp = new Employee();

		Department dept = genericD.fetchById(1, Department.class);

		System.out.println(dept);

		emp.setEmpNo(1003);
		emp.setName("adi");
		emp.setSalary(1000);
		emp.setDepartment(dept);

		genericD.create(emp);

	}

}
