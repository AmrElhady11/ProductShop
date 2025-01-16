package com.amazon_El8alaba.model;

import com.amazon_El8alaba.entity.CartEntity;
import com.amazon_El8alaba.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private double total_price;
    private LocalDateTime order_time;
    private CartEntity cart;
    private UserEntity user;
}
