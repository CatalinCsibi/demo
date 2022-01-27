package com.example.demo.controller.user;

import com.example.demo.model.user.AppUser;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/users")
@AllArgsConstructor
public class AppUserController {

    private final UserService userService;

    @GetMapping(path = "/{id}")
    public Optional<AppUser> getUser(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(Long userId) {
        userService.deleteById(userId);
    }
 }
