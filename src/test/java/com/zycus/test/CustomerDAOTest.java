package com.zycus.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.zycus.dao.CustomerDAO;
import com.zycus.dao.GenericDAO;
import com.zycus.entity.Account;
import com.zycus.entity.Address;
import com.zycus.entity.Customer;
import com.zycus.enums.Type;
import com.zycus.service.AccountService;

public class CustomerDAOTest {

	CustomerDAO customerD = new CustomerDAO();

	@Test
	public void testCreateCustomer() {

		Customer customer = new Customer();

		customer.setName("saurav");
		customer.setContact("9870364708");
		customer.setCity("Pune");

		customerD.create(customer);

	}

	@Test
	public void testFetchCustomer() {

		GenericDAO genericD = new GenericDAO();
		Customer customer = (Customer) genericD.fetchById(1, Customer.class);

		// assertNotNull(customer);
		System.out.println(customer);

	}

	@Test
	public void testUpdateCustomer() {

		Customer customer = customerD.fetchById(1);
		customer.setCity("Mumbai");
		customerD.update(customer);
		assertNotNull(customer);
		System.out.println(customer);

	}

	@Test
	public void testDeleteCustomer() {

		Customer customer = customerD.fetchById(1);
		customerD.delete(customer);
		System.out.println(customer);

	}

	@Test
	public void fetchAll() {

		for (Customer customer : customerD.fetchAll()) {
			System.out.println(customer);
		}

	}

	@Test
	public void testCreateCustomerWithAddress() {

		Customer customer = new Customer();

		customer.setName("aditya");
		customer.setContact("9870364708");
		customer.setCity("Pune");

		Address address = new Address();
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setPinCode(85);

		GenericDAO genericD = new GenericDAO();
		customer.setAddress(address);
		genericD.create(customer);

	}

	@Test
	public void demo() {
		AccountService service = new AccountService();
		Account account = new Account();
		account.setName("Aditya");
		account.setType(Type.SAVINGS);
		account.setBalance(1000l);

		service.openAccount(account);
	}

}
