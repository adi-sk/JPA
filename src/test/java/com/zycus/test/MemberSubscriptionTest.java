package com.zycus.test;

import java.util.Date;

import org.junit.Test;

import com.zycus.dao.GenericD;
import com.zycus.entity.MemberSubscription.Member;
import com.zycus.entity.MemberSubscription.MemberSubscriptionKey;
import com.zycus.entity.MemberSubscription.MemberSubscriptionLink;
import com.zycus.entity.MemberSubscription.MemberSubscriptionLink2;
import com.zycus.entity.MemberSubscription.Subscription;

public class MemberSubscriptionTest {

	GenericD genericD = new GenericD();

	@Test
	public void addMember() {
		Member member = new Member();
		member.setName("Adi");
		member.setEmail("adi2krh@gmail.com");

		genericD.create(member);
	}

	@Test
	public void addSubscription() {

		Subscription subscription = new Subscription();
		subscription.setSubscriptionfor("Amazon prime");
		subscription.setMonthlyFees(200);

		genericD.create(subscription);
	}

	@Test
	public void subscribe() {
		Member member = genericD.fetchById(1, Member.class);
		Subscription subscription = genericD.fetchById(2, Subscription.class);

		MemberSubscriptionLink link = new MemberSubscriptionLink();
		link.setSubscriptionDate(new Date());
		link.setDuration(2);
		link.setMember(member);
		link.setSubscription(subscription);

		genericD.create(link);

	}

	@Test
	public void subscribeWithEmbeddedKey() {
		Member member = genericD.fetchById(2, Member.class);
		Subscription subscription = genericD.fetchById(1, Subscription.class);

		MemberSubscriptionLink2 link = new MemberSubscriptionLink2();
		link.setSubscriptionDate(new Date());
		link.setDuration(2);

		MemberSubscriptionKey key = new MemberSubscriptionKey();
		key.setMember(member);
		key.setSubscription(subscription);
		link.setKey(key);

		genericD.create(link);

	}

}
