package com.example.javaChallange4.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.javaChallange4.entity.Customer;
import com.example.javaChallange4.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/test")
    public String test() {
        return "TEST SUCCESSFUL";
    }

    @GetMapping("")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("character")
    public List<Object[]> getCustomersAndOrderIdsByKeyword(@RequestParam("value") String value) {
        return customerService.getCustomersAndOrderIdsByKeyword(value);
    }

    @GetMapping("nullOrder")
    public List<Customer> getCustomersWithoutOrders() {
        return customerService.getCustomersWithoutOrders();
    }

    @GetMapping("/getById")
    public Customer getById(@RequestParam("id") UUID id) {
        return customerService.getById(id);
    }

    @PostMapping("")
    public String add(@RequestBody Customer customer) {
        customerService.add(customer);
        return "SUCCESSFUL ADDED";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable UUID id, @RequestBody Customer customer) {
        customerService.update(id, customer);
        return "SUCCESSFUL UPDATED";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        customerService.delete(id);
        return "SUCCESSFUL DELETED";
    }

}
