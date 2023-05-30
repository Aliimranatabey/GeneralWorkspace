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
import com.example.javaChallange4.entity.Order;
import com.example.javaChallange4.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/test")
    public String getTest() {
        return "TEST SUCCESSFUL";
    }

    @GetMapping("")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/getById")
    public Order getById(@RequestParam("id") UUID id) {
        return orderService.getById(id);
    }

    @GetMapping("/getOrdersAfterDate")
    public List<Order> getOrdersAfterDate(@RequestParam("startDate") String startDate) {
        return orderService.getOrdersAfterDate(startDate);
    }

    @PostMapping("")
    public String add(@RequestBody Order order) {
        orderService.add(order);
        return "SUCCESSFUL ADDED";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable UUID id, @RequestBody Order order) {
        orderService.update(id, order);
        return "SUCCESSFUL UPDATED";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable() UUID id) {
        orderService.delete(id);
        return "SUCCESSFUL DELETED";
    }
}
