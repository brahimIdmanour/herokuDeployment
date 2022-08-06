package com.eset.springappheroku3.model;

import com.eset.springappheroku3.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "customer has been added with the id " + customer.getId();
    }

    @GetMapping("/getCustomer")
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        boolean exists = customerRepository.existsById(id);
        Customer customer1 = customerRepository.findById(id);
        if(!exists) {
            return "customer does not exist with the id " + id;
        }
        customer1.setName(customer.getName());
        customer1.setSalary(customer.getSalary());
        customerRepository.save(customer1);
        return "customer updated with the id " +id;
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public  String deleteCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
        return "customer deleted with the id " +id;
    }
}
