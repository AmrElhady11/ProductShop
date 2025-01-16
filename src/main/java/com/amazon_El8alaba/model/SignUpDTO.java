package com.amazon_El8alaba.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {
    @NotNull(message = "You have to type your firstname,please")
    private String firstname;
    private String lastname;
    @Pattern(regexp = "^(?=[a-zA-Z0-9.]{8,20}$)(?!.*[.]{2})[^.].*[^.]$")
    @Size(min = 8 ,message = "Your username is too short")
    private String username;
    @Email
    private String email;
    @Pattern(regexp = "^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[a-zA-Z]).{8,}$",message = "password should have digits,capital & small chars")
    @Size(min=8,message = "Your password is Too short")
    private String password;
}
