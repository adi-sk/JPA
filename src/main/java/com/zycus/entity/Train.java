package com.zycus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "train")
public class Train {

	@Id
	@GeneratedValue
	private int trainNo;
	private String name;
	private String source;
	private String destination;

	@OneToMany()
	private Set<Booking> bookings;

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ "]";
	}

}
