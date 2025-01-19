package com.amazon_El8alaba.service;

import com.amazon_El8alaba.model.LoginDTO;
import com.amazon_El8alaba.model.SignUpDTO;

public interface AuthService {
    String Login(LoginDTO loginDTO);
    boolean register(SignUpDTO registerDTO);
    boolean forgotPassword(String email);
}
