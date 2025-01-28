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
public class SignUpDTO {
    private final LocalDateTime creationTime = LocalDateTime.now();
    private final LocalDateTime lastUpdateTime = LocalDateTime.now();
    private final Role role = Role.COSTUMER;

    private int id;
//    @NotNull(message = "You have to type your firstname,please")
    private String firstname;
    private String lastname;
//    @Pattern(regexp = "^(?=[a-zA-Z0-9.]{8,20}$)(?!.*[.]{2})[^.].*[^.]")
//    @Size(min = 8 ,message = "Your username is too short")
    private String username;
    @Email
    private String email;
    //    @Pattern(regexp = "^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[a-zA-Z]).{8,}",message = "password should have digits,capital & small chars")
//    @Size(min=8,message = "Your password is Too short")
    private String password;
}