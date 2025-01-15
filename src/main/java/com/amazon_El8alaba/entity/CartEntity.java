package com.amazon_El8alaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "total_price")
    private double total_price;
    @Column(name = "total_Products")
    private int total_Products;
    @Column(name = "discont")
    private double discont;
    @Column(name = "creation_time")
    private LocalDateTime creation_time;
    @Column(name = "last_updated_time")
    private LocalDateTime last_updated_time;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user ;
}
