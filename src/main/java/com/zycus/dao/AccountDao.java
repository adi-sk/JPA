package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Test;

import com.zycus.entity.Account;
import com.zycus.entity.Transaction;
import com.zycus.util.JPAUtil;

public class AccountDao extends GenericD {

	public double fetchBalance(int accno) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select a.balance from Account a where a.accno = :accno";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("accno", accno);

		return (Double) query.getSingleResult();
	}

	public List<Transaction> fetchStatement(int accno) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select t from Transaction t" + " where t.account.accno = :accno " + "ORDER BY t.date DESC";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("accno", accno);
		query.setMaxResults(2);
		return query.getResultList();
	}

	public List<Account> fetchAccountByTransactionAmount(double amount) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select distinct acc from Account acc join acc.transactions trx where trx.amount >= :amt";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("amt", amount);
		return query.getResultList();
	}

	@Test
	public List<Account> fetchAccountByTransactionMaxAmount() {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select distinct acc from Account acc join acc.transactions trx where trx.amount = (select MAX(trx.amount) from trx)";
		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

}
