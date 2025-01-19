package com.amazon_El8alaba.controller;

import com.amazon_El8alaba.entity.UserEntity;
import com.amazon_El8alaba.model.LoginDTO;
import com.amazon_El8alaba.model.SignUpDTO;
import com.amazon_El8alaba.service.AuthService;
import jakarta.servlet.http.HttpSession;
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
    @PostMapping("/signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("newUser", new SignUpDTO());
        return "signUpPage";

    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("theUser", new LoginDTO());
        return "LoginForm";

    }
    @PostMapping("/MainPage")
    public String processLogin(Model model,HttpSession session) {
        UserEntity theUser =authService.Login((LoginDTO) model.getAttribute("theUser"));
        if(theUser != null){
            session.setAttribute("currentUser",theUser);
            return "MainPage";
        }
        else
            return "LoginForm";

    }
    @PostMapping("/confirmationPage")
    public String test(@Valid @ModelAttribute("newUser") SignUpDTO userModel, BindingResult bindingResult, Model model) throws SQLException {

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
