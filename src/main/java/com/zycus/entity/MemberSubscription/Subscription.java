package com.zycus.entity.MemberSubscription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	@GeneratedValue
	private int id;
	private String subscriptionfor;
	private double monthlyFees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubscriptionfor() {
		return subscriptionfor;
	}

	public void setSubscriptionfor(String subscriptionfor) {
		this.subscriptionfor = subscriptionfor;
	}

	public double getMonthlyFees() {
		return monthlyFees;
	}

	public void setMonthlyFees(double monthlyFees) {
		this.monthlyFees = monthlyFees;
	}

}
