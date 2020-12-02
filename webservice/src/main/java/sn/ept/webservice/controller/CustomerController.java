package sn.ept.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.ept.webservice.model.Customer;
import sn.ept.webservice.service.CustomerServiceImpl;

@RestController
@RequestMapping("/wsapi")
public class CustomerController {

	CustomerServiceImpl customerService;

	@Autowired
	public CustomerController(CustomerServiceImpl customerService) {
		// TODO Auto-generated constructor stub
		this.customerService = customerService;
	}

	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(value = "/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) throws Exception {
		Customer customer = customerService.findById(id)
				.orElseThrow(() -> new Exception("Customer with " + id + " is Not Found!"));
		return customer;
	}

	@PostMapping(value = "/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping(value = "/customers/{id}")
	public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer newcust) throws Exception {
		Customer customer = customerService.findById(id)
				.orElseThrow(() -> new Exception("Customer with " + id + " is Not Found!"));
		customer.setPrenom(newcust.getPrenom());
		customer.setNom(newcust.getNom());
		customer.setDate_naissance(newcust.getDate_naissance());
		return customerService.save(customer);
	}

	@DeleteMapping(value = "/customers/{id}")
	public String deleteStudent(@PathVariable("id") int id) throws Exception {
		Customer customer = customerService.findById(id)
				.orElseThrow(() -> new Exception("Customer with " + id + " is Not Found!"));
		customerService.deleteById(customer.getId());
		return "Customer with ID :" + id + " is deleted";
	}
}
