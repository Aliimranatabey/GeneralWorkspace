package com.example.javaChallange4.repository;

import com.example.javaChallange4.entity.Customer;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query(value = "SELECT c.name, o.id FROM Customer c LEFT JOIN c.orders o WHERE (:value = '' OR LOWER(c.name) LIKE LOWER(concat('%', concat(:value, '%'))))")
    List<Object[]> findCustomersAndOrderIdsByKeyword(@Param("value") String value);

    @Query("SELECT c FROM Customer c WHERE c.orders IS EMPTY")
    List<Customer> findCustomersWithoutOrders();

}
