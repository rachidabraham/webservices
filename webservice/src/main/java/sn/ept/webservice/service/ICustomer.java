package sn.ept.webservice.service;

import java.util.List;
import java.util.Optional;

import sn.ept.webservice.model.Customer;

public interface ICustomer {

	Customer createCustomer(Customer customer);
	
	List<Customer> getAllCustomers();

	Optional<Customer> findById(int id);

	Optional<Customer> findByName(String prenom);

	Customer save(Customer customer);

	void deleteById(int id);

}