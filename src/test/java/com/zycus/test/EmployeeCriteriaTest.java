package com.zycus.test;

import org.junit.Test;

import com.zycus.entity.QueryPracticeCriteriaAPI.DeptEmpDAO;
import com.zycus.entity.QueryPracticeCriteriaAPI.Employee2;

public class EmployeeCriteriaTest {

	DeptEmpDAO deptEmpD = new DeptEmpDAO();

	@Test
	public void getAllEmployees() {
		for (Employee2 emp : deptEmpD.fetchAllEmployees()) {
			System.out.println("Emp No:" + emp.getEmpNo());
			System.out.println("Emp Name:" + emp.getName());
			System.out.println("Emp Salary:" + emp.getSalary());
			System.out.println();
			System.out.println("====================================================");
		}
	}

	@Test
	public void getEmployeeNoName() {
		for (Object[] emp : deptEmpD.fetchEmployeeNumberAndName()) {
			System.out.println(emp[0]);
			System.out.println(emp[1]);
			System.out.println();

		}
	}

	@Test
	public void getAllEmployeesGreaterThanSalary() {
		for (Employee2 emp : deptEmpD.fetchAllEmployeesBySalary(10)) {
			System.out.println("Emp No:" + emp.getEmpNo());
			System.out.println("Emp Name:" + emp.getName());
			System.out.println("Emp Salary:" + emp.getSalary());
			System.out.println();
			System.out.println("====================================================");
		}
	}

	@Test
	public void getAllEmployeesGreaterThanSalaryAndName() {
		for (Employee2 emp : deptEmpD.fetchAllEmployeesBySalaryAndName(100, "dit")) {
			System.out.println("Emp No:" + emp.getEmpNo());
			System.out.println("Emp Name:" + emp.getName());
			System.out.println("Emp Salary:" + emp.getSalary());
			System.out.println();
			System.out.println("====================================================");
		}
	}

	@Test
	public void getAllEmployeesByDeptName() {
		for (Employee2 emp : deptEmpD.fetchAllEmployeesByDepartmentName("HR")) {
			System.out.println("Emp No:" + emp.getEmpNo());
			System.out.println("Emp Name:" + emp.getName());
			System.out.println("Emp Salary:" + emp.getSalary());
			System.out.println();
			System.out.println("====================================================");
		}
	}

}
