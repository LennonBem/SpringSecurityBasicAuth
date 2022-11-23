package com.example.springsecurity.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {
    @NotBlank(message = "Username é obrigatório!")
    private String username;
    @NotBlank(message = "Password é obrigatório!")
    private String password;
        }
