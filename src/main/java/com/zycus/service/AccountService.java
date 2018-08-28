package com.zycus.service;

import java.util.Date;
import java.util.List;

import com.zycus.dao.AccountDao;
import com.zycus.entity.Account;
import com.zycus.entity.Transaction;
import com.zycus.enums.TrxType;

public class AccountService {

	AccountDao accountD = new AccountDao();

	public void openAccount(Account account) {

		accountD.create(account);

	}

	public void withdraw(int accno, double amount) {
		Account account = accountD.fetchById(accno, Account.class);

		double finalAmount = account.getBalance() - amount;
		account.setBalance(finalAmount);

		Transaction trx = new Transaction();
		long utilDate = new Date().getTime();
		trx.setDate(new java.sql.Date(utilDate));
		trx.setAmount(amount);
		trx.setTrxType(TrxType.WITHDRAW);

		trx.setAccount(account);

		accountD.update(account);
		accountD.create(trx);

	}

	public void deposit(int accno, double amount) {
		Account account = accountD.fetchById(accno, Account.class);

		double finalAmount = account.getBalance() + amount;
		account.setBalance(finalAmount);

		Transaction trx = new Transaction();
		long utilDate = new Date().getTime();
		trx.setDate(new java.sql.Date(utilDate));
		trx.setAmount(amount);
		trx.setTrxType(TrxType.DEPOSITE);

		trx.setAccount(account);

		accountD.update(account);
		accountD.create(trx);

	}

	public void transfer(int fromaccno, int toaccno, double amount) {

		withdraw(fromaccno, amount);
		deposit(toaccno, amount);

	}

	public double balance(int accno) {
		return accountD.fetchBalance(accno);
	}

	public List<Transaction> miniStatement(int accno) {

		return accountD.fetchStatement(accno);
	}

	public List<Account> getAccountByAmount(double amount) {

		return accountD.fetchAccountByTransactionAmount(amount);
	}

	public List<Account> getAccountByMaxAmount() {
		return accountD.fetchAccountByTransactionMaxAmount();
	}

}
