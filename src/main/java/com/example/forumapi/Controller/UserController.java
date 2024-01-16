package com.example.forumapi.Controller;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.entity.Reply;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/postQuestion")
    public ResponseEntity<List<Question>> uploadQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.upload(question));
    }

    @PostMapping("/postAnswer/{qId}")
    public ResponseEntity<List<Question>> uploadAnswer(@RequestBody Answer answer, @PathVariable String qId){
        return ResponseEntity.ok(answerService.uploadAns(answer, Long.parseLong(qId)));
    }

    @PostMapping("/replyToAns/{aID}")
    public ResponseEntity<List<Question>> RepliesToAns(@RequestBody Reply reply, @PathVariable String aID){
        return ResponseEntity.ok(answerService.uploadRep(reply, Long.parseLong(aID)));
    }
}
