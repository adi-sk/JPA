package com.zycus.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")

public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "Cust_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "contact")
	private String contact;

	@Column(name = "city")
	private String city;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id")
	private Address address;

	public Customer(int id, String name, String contact, String city) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.city = city;
	}

	public Customer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + ", city=" + city + "]";
	}

}
