package com.example.springsecurity.controller;

import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.request.UserRequest;
import com.example.springsecurity.model.response.UserResponse;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody @Valid UserRequest userRequest) {
        try {

            UserEntity userEntity = userService.newUser(userRequest);
            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(userEntity, UserResponse.class);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
          return   ResponseEntity.badRequest().body("Usuário já existe!");
        }
    }



}
