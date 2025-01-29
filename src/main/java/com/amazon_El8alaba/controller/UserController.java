package com.amazon_El8alaba.controller;

import com.amazon_El8alaba.model.LoginDTO;
import com.amazon_El8alaba.model.SignUpDTO;
import com.amazon_El8alaba.model.User;
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
    @RequestMapping("/createAccount")
    public String showSignUpForm(Model model) {
        model.addAttribute("newUser", new SignUpDTO());
        return "UserManagement/signUpPage";

    }
    @PostMapping("/confirmation")
    public String test(@Valid @ModelAttribute("newUser") SignUpDTO userModel, BindingResult bindingResult) throws SQLException {

        if(bindingResult.hasErrors())
            return "UserManagement/signUpPage";

        boolean result =  authService.register(userModel);
        if(result)
            System.out.println(String.format("Employee %s saved successfully", userModel.getFirstname()));
        else
            System.out.println(String.format("Employee %s save failed", userModel.getFirstname()));

        return "UserManagement/confirmationPage";

    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("theUser", new LoginDTO());
        return "UserManagement/LoginForm";

    }
    @PostMapping("/MainPage")
    public String processLogin(@ModelAttribute("theUser") LoginDTO user, HttpSession session,Model model) {
        User theUser =authService.Login((LoginDTO)user);
        if(theUser != null){

               session.setAttribute("currentUser",theUser);

            return "redirect:/home";
        }
        else
            return "UserManagement/LoginForm";

    }
    @GetMapping("/forgotPassword")
    public String forgotPassword(Model model){

        model.addAttribute("theUser",new User());
        return "UserManagement/findEmail";

    }
    @ResponseBody
    @RequestMapping("/sendVerificationCode")
    public String confirmPassword(@Valid @ModelAttribute("theUser") User userModel, BindingResult bindingResult,Model model){
            model.addAttribute("theUser",userModel);

        return "UserManagement/VerificationCode";
    }


}