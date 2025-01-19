package com.amazon_El8alaba.service;

import com.amazon_El8alaba.model.LoginDTO;
import com.amazon_El8alaba.model.SignUpDTO;
import com.amazon_El8alaba.model.User;

public interface AuthService {
    User Login(LoginDTO loginDTO);
    boolean register(SignUpDTO registerDTO);
    boolean forgotPassword(String email);
}
