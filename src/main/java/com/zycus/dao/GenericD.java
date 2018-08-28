package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.zycus.util.JPAUtil;

public class GenericD {

	public <T> void create(T entity) {
		// STEP 1: create session factory
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.persist(entity);

		tx.commit();
		entityManager.close();
	}

	public <T> void update(T entity) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		entityManager.merge(entity);

		tx.commit();
		entityManager.close();

	}

	public <T> void delete(Object id, Class<T> clazz) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		T entity = (T) entityManager.find(clazz, id);
		entityManager.remove(entity);

		tx.commit();
		entityManager.close();

	}

	public <T> T fetchById(Object id, Class<T> clazz) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {

			return (T) entityManager.find(clazz, id);

		} finally {
			entityManager.close();
		}
	}

	public <T> List<T> fetchAll(Class<T> clazz) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String str = "select o from " + clazz.getName() + " as o";
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
