package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.zycus.util.JPAUtil;

public class GenericDAO {

	public void create(Object obj) {
		// STEP 1: create session factory
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.persist(obj);

		tx.commit();
		entityManager.close();
	}

	public void update(Object obj) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.merge(obj);

		tx.commit();
		entityManager.close();

	}

	public void delete(Object obj) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.remove(obj);

		tx.commit();
		entityManager.close();

	}

	public <E> E fetchById(Object id, Class<E> clas) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			System.out.println(clas);
			E objr = entityManager.find(clas, id);
			return objr;

		} finally {
			entityManager.close();
		}
	}

	public <E> List<E> fetchAll(Class<E> clas) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String str = "select o from " + clas.getName() + " as o";
		javax.persistence.Query query = entityManager.createQuery(str); // HQL
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
