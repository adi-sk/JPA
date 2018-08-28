package com.zycus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.zycus.enums.Type;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private int accno;

	private String name;
	private Type type;
	private double balance;

	@OneToMany(mappedBy = "account")
	private Set<Transaction> transactions;

	public int getAccno() {
		return accno;
	}

	public Account() {

	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", name=" + name + ", type=" + type + ", balance=" + balance + "]";
	}

}
