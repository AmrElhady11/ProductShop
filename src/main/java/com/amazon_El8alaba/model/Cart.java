package com.amazon_El8alaba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private double total_price;
    private int total_Products;
    private double discount;
    private LocalDateTime creation_time;
    private LocalDateTime last_updated_time;
    private int userID ;
}
