package com.zycus.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory sessionFactory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			// Create the EntityManagerFactory from META-INF/persistence.xml
			return Persistence.createEntityManagerFactory("persistence-test"); // persistence
																				// unit
																				// name
																				// in
																				// persistence.xml
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return sessionFactory;
	}
}
