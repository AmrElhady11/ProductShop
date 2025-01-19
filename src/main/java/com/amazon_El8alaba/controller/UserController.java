package com.amazon_El8alaba.controller;

import com.amazon_El8alaba.entity.UserEntity;
import com.amazon_El8alaba.model.LoginDTO;
import com.amazon_El8alaba.model.SignUpDTO;
import com.amazon_El8alaba.model.User;
import com.amazon_El8alaba.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@Controller
public class UserController {
    private final AuthService authService;

    @Autowired
    public UserController(AuthService authService) {
        this.authService = authService;
    }
    @RequestMapping("/createAccount")
    public String showSignUpForm(Model model) {
        model.addAttribute("newUser", new SignUpDTO());
        return "signUpPage";

    }
    @PostMapping("/confirmation")
    public String test(@Valid @ModelAttribute("newUser") SignUpDTO userModel, BindingResult bindingResult, Model model) throws SQLException {

        if(bindingResult.hasErrors())
            return "signUpPage";

        boolean result =  authService.register(userModel);
        if(result)
            System.out.println(String.format("Employee %s saved successfully", userModel.getFirstname()));
        else
            System.out.println(String.format("Employee %s save failed", userModel.getFirstname()));

        return "confirmationPage";

    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("theUser", new LoginDTO());
        return "LoginForm";

    }
    @PostMapping("/MainPage")
    public String processLogin(@ModelAttribute("theUser") LoginDTO user, HttpServletRequest request,Model model) {
        System.out.println(user.getUsername());
        User theUser =authService.Login((LoginDTO)user);
        if(theUser != null){
//            HttpSession session = request.getSession();

//            session.setAttribute("currentUser",theUser);
            System.out.println("iam not null");
            model.addAttribute("currentUser",theUser);

            return "MainPage";
        }
        else
            return "LoginForm";

    }


}
