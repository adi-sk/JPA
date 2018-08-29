package com.zycus.entity.MemberSubscription;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MemberSubscriptionLink2 {

	@EmbeddedId
	private MemberSubscriptionKey key;

	private Date subscriptionDate;
	private int duration;

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public MemberSubscriptionKey getKey() {
		return key;
	}

	public void setKey(MemberSubscriptionKey key) {
		this.key = key;
	}
}
