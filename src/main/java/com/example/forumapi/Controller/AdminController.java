package com.example.forumapi.Controller;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final QuestionService questionService;
    private final AnswerService answerService;

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

    @DeleteMapping("/deleteQue/{id}")
    public ResponseEntity<List<Question>> deleteQ(@PathVariable String id){
        return  ResponseEntity.ok(questionService.deleteQuestion(Long.parseLong(id)));
    }

    @PutMapping("/updateQue/{id}")
    public ResponseEntity<List<Question>> updateQ(@RequestBody Question que, @PathVariable String id){
        return  ResponseEntity.ok(questionService.updateQuestion(que, Long.parseLong(id)));
    }
}
