package com.example.springsecurity.controller;

import com.example.springsecurity.model.request.LoginRequest;
import com.example.springsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;



    @PostMapping
    public void loginByUsernameAndPassword(@RequestBody LoginRequest loginRequest){
        try {
            loginService.loginByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        }catch (Exception e){
        e.getMessage();
    }finally {

        }
        }
}
