package com.zycus.entity.QueryPracticeCriteriaAPI;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.zycus.dao.GenericD;
import com.zycus.util.JPAUtil;

public class DeptEmpDAO extends GenericD {

	public List<Employee2> fetchAllEmployees() {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee2> criteria = criteriaBuilder.createQuery(Employee2.class);

		Root<Employee2> emp = criteria.from(Employee2.class);

		criteria.select(emp);

		return entityManager.createQuery(criteria).getResultList();

	}

	public List<Object[]> fetchEmployeeNumberAndName() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);

		Root<Employee2> emp = criteria.from(Employee2.class);

		criteria.multiselect(emp.get("empNo"), emp.get("name"));

		return entityManager.createQuery(criteria).getResultList();

	}

	public List<Employee2> fetchAllEmployeesBySalary(double salary) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee2> criteria = criteriaBuilder.createQuery(Employee2.class);

		Root<Employee2> emp = criteria.from(Employee2.class);

		criteria.select(emp);
		criteria.where(criteriaBuilder.ge(emp.<Double> get("salary"), salary));

		return entityManager.createQuery(criteria).getResultList();

	}

	public List<Employee2> fetchAllEmployeesBySalaryAndName(double salary, String pattern) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee2> criteria = criteriaBuilder.createQuery(Employee2.class);

		Root<Employee2> emp = criteria.from(Employee2.class);

		criteria.select(emp);
		criteria.where(criteriaBuilder.and(criteriaBuilder.ge(emp.<Double> get("salary"), salary),
				criteriaBuilder.like(emp.<String> get("name"), "%" + pattern + "%")));

		return entityManager.createQuery(criteria).getResultList();

	}

	public List<Employee2> fetchAllEmployeesByDepartmentName(String deptName) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee2> criteria = criteriaBuilder.createQuery(Employee2.class);

		Root<Employee2> emp = criteria.from(Employee2.class);
		Join<Employee2, Department2> dept = emp.join("department", JoinType.INNER);
		criteria.select(emp);

		criteria.where(criteriaBuilder.equal(dept.<String> get("name"), deptName));

		return entityManager.createQuery(criteria).getResultList();

	}

}
