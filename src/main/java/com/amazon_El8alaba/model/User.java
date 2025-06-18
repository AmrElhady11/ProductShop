package com.amazon_El8alaba.model;


import com.amazon_El8alaba.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private  LocalDateTime creationTime ;
    private  LocalDateTime lastUpdateTime ;
    private  Role role;

}