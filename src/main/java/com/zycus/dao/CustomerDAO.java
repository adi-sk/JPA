package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.zycus.entity.Customer;
import com.zycus.util.JPAUtil;

public class CustomerDAO {
	public void create(Customer customer) {
		// STEP 1: create session factory
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.persist(customer);

		tx.commit();
		entityManager.close();
	}

	public void update(Customer customer) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.merge(customer);

		tx.commit();
		entityManager.close();

	}

	public void delete(Customer customer) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.remove(customer);

		tx.commit();
		entityManager.close();

	}

	public Customer fetchById(int customerId) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {

			Customer customer = (Customer) entityManager.find(Customer.class, customerId);
			entityManager.close();
			return customer;
		} finally {
			entityManager.close();
		}
	}

	public List<Customer> fetchAll() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		javax.persistence.Query query = entityManager.createQuery("SELECT c from Customer as c"); // HQL
		// Hibernate
		// Query
		// Language

		try {
			return query.getResultList();
		} finally {
			entityManager.close();
		}
	}

}
