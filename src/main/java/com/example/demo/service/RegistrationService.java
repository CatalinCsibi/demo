package com.example.demo.service;

import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(RegistrationRequest request) {

        userService.singUpNewUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));

        return "User was successfully registered";

    }
}
