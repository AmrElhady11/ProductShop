package com.amazon_El8alaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name="production_time")
    private LocalDateTime productionTime;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "availability")
    private boolean availability;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "last_updated_time")
    private LocalDateTime lastUpdateTime;
}
