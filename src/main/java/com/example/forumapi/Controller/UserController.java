package com.example.forumapi.Controller;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/postQuestion")
    public ResponseEntity<Question> uploadQuestion(@RequestBody Question question, Principal principal){
        return ResponseEntity.ok(questionService.upload(question, principal.getName()));
    }

    @PostMapping("/postAnswer")
    public ResponseEntity<Answer> uploadAnswer(@RequestBody Answer answer){
        return ResponseEntity.ok(answerService.upload(answer));
    }

}
