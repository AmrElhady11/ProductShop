package com.amazon_El8alaba.entity;

import com.amazon_El8alaba.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Transient
    private String confirmPassword;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role ;
    @Column(name = "creation_time")
    private  LocalDateTime creationTime;
    @Column(name = "last_updated_time")
    private LocalDateTime lastUpdateTime;

}