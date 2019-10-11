package me.ibrokhim.controller;

import me.ibrokhim.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @GetMapping
    public String index() {
        return null; // Todo
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user) {
        return null; // Todo
    }

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return null; // Todo
    }

    @PostMapping(value = "/logout")
    public String logout() {
        return null; // Todo
    }
}
