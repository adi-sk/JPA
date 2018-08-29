package com.zycus.entity.inheritanceThreeTable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "payment_id", referencedColumnName = "id")
public class CreditCard3 extends PaymentDetails3 {

	private long cardNo;
	private Date expiryDate;
	private int cvv;

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCard [cardNo=" + cardNo + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
	}

}
