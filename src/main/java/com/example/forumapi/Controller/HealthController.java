package com.example.forumapi.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Forum API is live!";
    }
}
