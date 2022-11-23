package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);

        String senhaEncpoder = new BCryptPasswordEncoder().encode("123456");
        System.out.println(new BCryptPasswordEncoder().matches("26785641","$2a$10$X0hLN2D94Tzugld.QciNUOBNUyJFSBmPzoVr76xFCtVPmHxQ3/cHe"));
    }


}
