package com.zycus.test;

import java.util.Date;

import org.junit.Test;

import com.zycus.dao.GenericD;
import com.zycus.entity.inheritanceThreeTable.BankAccount3;
import com.zycus.entity.inheritanceThreeTable.CreditCard3;

public class AccountCardPaymentTest {

	GenericD genericD = new GenericD();

	@Test
	public void addPaymentDetailsAccount() {
		BankAccount3 accountPay = new BankAccount3();
		accountPay.setNameOfThePerson("Aditya");
		accountPay.setAmount(1000);
		accountPay.setBankName("ICICI");
		accountPay.setAccNo(123);

		genericD.create(accountPay);

	}

	@Test
	public void addPaymentDetailsCard() {
		CreditCard3 card = new CreditCard3();
		card.setNameOfThePerson("adi");
		card.setAmount(2000);
		card.setCardNo(1234565);
		card.setExpiryDate(new Date());
		card.setCvv(224);

		genericD.create(card);
	}

}
