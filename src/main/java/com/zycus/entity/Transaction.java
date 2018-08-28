package com.zycus.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zycus.enums.TrxType;

@Entity
@Table(name = "Logs")
public class Transaction {

	@Id
	@GeneratedValue
	private int trxno;
	private Date date;
	private double amount;
	private TrxType trxType;

	@ManyToOne
	@JoinColumn(name = "accno")
	public Account account;

	public Transaction() {

	}

	public int getTrxno() {
		return trxno;
	}

	public void setTrxno(int trxno) {
		this.trxno = trxno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TrxType getTrxType() {
		return trxType;
	}

	public void setTrxType(TrxType trxType) {
		this.trxType = trxType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [trxno=" + trxno + ", date=" + date + ", amount=" + amount + ", trxType=" + trxType
				+ ", account=" + account + "]";
	}

}
