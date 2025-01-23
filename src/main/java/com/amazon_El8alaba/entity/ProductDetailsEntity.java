package com.amazon_El8alaba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
    @Entity
    @Table(name = "product_details")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ProductDetailsEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @JoinColumn(name = "product_id")
        private ProductEntity productId;

        @Column
        private String name;

        @Column
        private LocalDate expirationDate;

        @Column
        private String manufacturer;

        @Column
        private Double price;

        @Column
        private Boolean available ;
        @Override
        public String toString() {
            return "ProductDetailsEntity{" +
                    "productId=" + (productId != null ? productId.getId() : "null") +
                    '}';
        }

    }
