package com.example.springsecurity.service;

import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.response.UserResponse;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public void loginByUsernameAndPassword(String username, String password) throws Exception {

      UserEntity user = userRepository.findByUsername(username).orElseThrow(
              () -> new Exception("Usuário não existe!") );

       boolean bool = passwordValid(password, user.getPassword());
        System.out.println(bool);


    }

    private  boolean passwordValid(String password, String encoderPassword) {
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       return   encoder.matches(password,encoderPassword );
    }
}
