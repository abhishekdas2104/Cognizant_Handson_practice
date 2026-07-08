package com.example.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController{
@Autowired
private CustomerRepository customerRepository;
@GetMapping
public List<Customer> getAllCustomers(){
return customerRepository.findAll();
}
@GetMapping("/{id}")
public Customer getCustomerById(@PathVariable Long id){
return customerRepository.findById(id).orElse(null);
}
@PostMapping
public Customer createCustomer(@RequestBody Customer customer){
return customerRepository.save(customer);
}
}
