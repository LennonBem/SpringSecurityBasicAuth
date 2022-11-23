package com.example.springsecurity.config.Security;

import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.response.UserResponse;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userResponse = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not Found!" + username));

        return new User(userResponse.getUsername(),userResponse.getPassword(),true,true,true, true, userResponse.getAuthorities());
    }
}
