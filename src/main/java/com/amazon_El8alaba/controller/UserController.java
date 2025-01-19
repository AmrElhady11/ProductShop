package com.amazon_El8alaba.controller;

import com.amazon_El8alaba.model.SignUpDTO;
import com.amazon_El8alaba.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class UserController {
    private final AuthService authService;

    @Autowired
    public UserController(AuthService authService) {
        this.authService = authService;
    }
    @RequestMapping("/signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("signUpDTO", new SignUpDTO());
        return "signUpPage";

    }
    @RequestMapping("/MainPage")
    public String test(@Valid @ModelAttribute("signUpDTO") SignUpDTO userModel, BindingResult bindingResult, Model model) throws SQLException {

        if(bindingResult.hasErrors())
            return "signUpPage";

        boolean result =  authService.register(userModel);
        if(result)
            System.out.println(String.format("Employee %s saved successfully", userModel.getFirstname()));
        else
            System.out.println(String.format("Employee %s save failed", userModel.getFirstname()));

        return "MainPage";

    }

}
