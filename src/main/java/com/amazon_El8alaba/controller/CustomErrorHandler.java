package com.amazon_El8alaba.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorHandler implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status =  request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null &&  Integer.valueOf(status.toString())== HttpStatus.NOT_FOUND.value())
            return "ErrorManagement/Error404";
        if(status != null &&  Integer.valueOf(status.toString())== HttpStatus.FORBIDDEN.value())
            return "ErrorManagement/NotAllowed";
        return "ErrorManagement/ErrorPage";
    }
}
