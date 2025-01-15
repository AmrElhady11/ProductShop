package com.amazon_El8alaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name ="total_price" )
    private double total_price;
    @Column(name = "order_time")
    private LocalDateTime order_time;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
