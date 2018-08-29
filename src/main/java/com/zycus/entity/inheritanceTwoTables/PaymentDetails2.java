package com.zycus.entity.inheritanceTwoTables;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PaymentDetails2 {

	@Id
	@GeneratedValue
	private int id;
	private String nameOfThePerson;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfThePerson() {
		return nameOfThePerson;
	}

	public void setNameOfThePerson(String nameOfThePerson) {
		this.nameOfThePerson = nameOfThePerson;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
