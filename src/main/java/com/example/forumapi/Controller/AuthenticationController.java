package com.example.forumapi.Controller;

import com.example.forumapi.Dao.JwtAuthenticationResponse;
import com.example.forumapi.Dao.SignUpRequest;
import com.example.forumapi.Dao.SigninRequest;
import com.example.forumapi.entity.User;
import com.example.forumapi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/forall")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hey public");
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup (@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
}
