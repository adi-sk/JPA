package com.zycus.entity.inheritanceThreeTable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "payment_id", referencedColumnName = "id")
public class BankAccount3 extends PaymentDetails3 {

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
