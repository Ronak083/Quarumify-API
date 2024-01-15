package com.example.forumapi.Controller;

import com.example.forumapi.Dao.JwtAuthUserDetails;
import com.example.forumapi.Dao.JwtAuthenticationResponse;
import com.example.forumapi.Dao.SignUpRequest;
import com.example.forumapi.Dao.SigninRequest;
import com.example.forumapi.entity.Question;
import com.example.forumapi.entity.User;
import com.example.forumapi.service.AuthenticationService;
import com.example.forumapi.service.JwtService;
import com.example.forumapi.service.QuestionService;
import com.example.forumapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final QuestionService questionService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup (@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @GetMapping("/userDetail/{username}")
    public ResponseEntity<User> getUserInfo(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserInfo(username));
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getQuestion(){
        return ResponseEntity.ok(questionService.getQuestions());
    }
}
