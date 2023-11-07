package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")

public class IndexController {

    @GetMapping
    public String get() {
        return "Get Spring Boot";
    }

    @PostMapping("/login/{login}/senha/{senha}")
    public String login(@PathVariable("login") String login, @PathVariable("senha") String senha) {
        return  "Login: " + login + ", senha: "+senha;
    }

}
