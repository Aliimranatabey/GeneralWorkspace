package com.example.javaChallange4.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.javaChallange4.entity.Order;
import com.example.javaChallange4.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found company " + id.toString()));
    }

    public List<Order> getOrdersAfterDate(String startDate) {
        return orderRepository.findOrdersAfterDate(startDate);
    }

    public Order add(Order order) {
        return orderRepository.save(order);
    }

    public Order update(UUID id, Order order) {
        return orderRepository.saveAndFlush(order);
    }

    public void delete(UUID id) {
        orderRepository.deleteById(id);
    }

}