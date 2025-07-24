package com.example.forumapi.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Forum API is live!";
    }
}
