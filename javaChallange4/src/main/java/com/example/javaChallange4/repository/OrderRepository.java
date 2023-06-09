package com.example.javaChallange4.repository;

import com.example.javaChallange4.entity.Order;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o FROM Order o WHERE (:startDate = '' OR :startDate IS NULL OR to_date(to_char(o.createDate, 'yyyy-mm-dd'),'yyyy-mm-dd') >= to_date(:startDate,'yyyy-mm-dd'))")
    List<Order> findOrdersAfterDate(String startDate);

}
