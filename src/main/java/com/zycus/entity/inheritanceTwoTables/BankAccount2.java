package com.zycus.entity.inheritanceTwoTables;

import javax.persistence.Entity;

@Entity
public class BankAccount2 extends PaymentDetails2 {

	private String bankName;
	private long accNo;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	@Override
	public String toString() {
		return "BankAccount [bnakName=" + bankName + ", accNo=" + accNo + "]";
	}

}
