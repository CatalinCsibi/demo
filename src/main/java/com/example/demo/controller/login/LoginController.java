package com.example.demo.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    private static Logger logger;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
