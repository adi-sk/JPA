package com.zycus.test;

import org.junit.Test;

import com.zycus.entity.Account;
import com.zycus.entity.Transaction;
import com.zycus.enums.Type;
import com.zycus.service.AccountService;

public class AccountTransactionTest {

	AccountService service = new AccountService();

	@Test
	public void addAccount() {
		AccountService service = new AccountService();
		Account account = new Account();
		account.setName("Adi");
		account.setType(Type.CURRENT);
		account.setBalance(2000);

		service.openAccount(account);
	}

	@Test
	public void withdraw() {
		service.withdraw(1, 100);
	}

	@Test
	public void deposit() {
		service.deposit(2, 3000);
	}

	@Test
	public void transfer() {
		service.transfer(1, 2, 200);
	}

	@Test
	public void getBalance() {
		System.out.println(service.balance(1));
	}

	@Test
	public void getMini() {
		for (Transaction trx : service.miniStatement(1)) {
			System.out.println(trx);
		}
		;
	}

	@Test
	public void getAccountByAmount() {
		for (Account acc : service.getAccountByAmount(2500)) {
			System.out.println(acc);
		}

	}

	@Test
	public void getAccountByMaxAmount() {
		for (Account acc : service.getAccountByMaxAmount()) {
			System.out.println(acc);
		}
	}
}
