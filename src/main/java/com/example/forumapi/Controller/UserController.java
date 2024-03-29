package com.example.forumapi.Controller;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.entity.Reply;
import com.example.forumapi.entity.User;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.QuestionService;
import com.example.forumapi.service.ReplyService;
import com.example.forumapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;
    private final ReplyService replyService;
    @PostMapping("/postQuestion")
    public ResponseEntity<Question> uploadQuestion(@RequestBody Question question){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(questionService.upload(question, userID));
    }

    @PostMapping("/postAnswer/{qId}")
    public ResponseEntity<Answer> uploadAnswer(@RequestBody Answer answer, @PathVariable String qId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        com.example.forumapi.entity.User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(answerService.uploadAns(answer, Long.parseLong(qId), userID));
    }

    @PostMapping("/postReply/{aID}")
    public ResponseEntity<Reply> RepliesToAns(@RequestBody Reply reply, @PathVariable String aID){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(replyService.uploadRep(reply, Long.parseLong(aID), userID));
    }

    @DeleteMapping("/deleteQuestion/{qid}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String qid){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(questionService.deleteQuestion(Long.parseLong(qid), userID));
    }

    @DeleteMapping("/deleteAnswer/{aid}")
    public ResponseEntity<String> deleteAnswer(@PathVariable String aid){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(answerService.deleteAnswer(Long.parseLong(aid), userID));
    }

    @DeleteMapping("/deleteReply/{rid}")
    public ResponseEntity<String> deleteReply(@PathVariable String rid){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(replyService.deleteReply(Long.parseLong(rid), userID));
    }

    @PutMapping("/updateQuestion/{qid}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question que, @PathVariable String qid){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(questionService.updateQuestion(que, Long.parseLong(qid), userID));
    }

    @PutMapping("/updateAnswer/{aid}")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer ans, @PathVariable String aid){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(answerService.updateAnswer(ans, Long.parseLong(aid), userID));
    }

    @PutMapping("/updateReply/{rid}")
    public ResponseEntity<Reply> updateReply(@RequestBody Reply reply, @PathVariable String rid){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = jwtUser.getId();
        return ResponseEntity.ok(replyService.updateReply(reply, Long.parseLong(rid), userID));
    }



    @PutMapping("/updateUserBio")
    public ResponseEntity<User> updateBio(@RequestBody User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();
        long userID = (jwtUser.getId());
        return ResponseEntity.ok(userService.updateBio(user, userID));
    }

}