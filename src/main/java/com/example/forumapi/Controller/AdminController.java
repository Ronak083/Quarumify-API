package com.example.forumapi.Controller;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.QuestionService;
import com.example.forumapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.forumapi.entity.User;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    @DeleteMapping("/deleteQue/{id}")
    public ResponseEntity<List<Question>> deleteQ(@PathVariable String id){
        return  ResponseEntity.ok(questionService.deleteQuestion(Long.parseLong(id)));
    }

    @PostMapping("/postQuestion")
    public ResponseEntity<List<Question>> uploadQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.upload(question));
    }

    @PostMapping("/postAnswer/{qId}")
    public ResponseEntity<List<Question>> uploadAnswer(@RequestBody Answer answer, @PathVariable String qId){
        return ResponseEntity.ok(answerService.upload(answer, Long.parseLong(qId)));
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getQuestion(){
        return ResponseEntity.ok(questionService.getQuestions());
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/updateRoleToMOD/{id}")
    public ResponseEntity<List<User>> updateRoleToMOD(@PathVariable String id){
        return ResponseEntity.ok(userService.updateToModerator(Long.parseLong(id)));
    }

    @PutMapping("/updateRoleToUSR/{id}")
    public ResponseEntity<List<User>> updateRoleToUSR(@PathVariable String id){
        return ResponseEntity.ok(userService.updateToUser(Long.parseLong(id)));
    }
}
