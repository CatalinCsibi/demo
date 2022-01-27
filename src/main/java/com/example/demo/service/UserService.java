package com.example.demo.service;

import com.example.demo.model.user.AppUser;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with username %s not found";

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format(USER_NOT_FOUND, username)
        ));
    }

    public AppUser singUpNewUser(AppUser user) {
        boolean usernameExists = userRepository.findByUsername(user.getUsername()).isPresent();
        if(usernameExists) {
            throw new IllegalStateException("Username already taken");
        }

        boolean emailExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if(emailExists) {
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        return user;

    }
}
