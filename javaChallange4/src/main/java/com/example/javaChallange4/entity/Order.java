package com.example.javaChallange4.entity;

import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.annotation.RestResource;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}