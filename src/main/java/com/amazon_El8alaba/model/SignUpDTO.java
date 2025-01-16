package com.amazon_El8alaba.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
