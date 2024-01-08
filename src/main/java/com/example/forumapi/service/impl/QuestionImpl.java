package com.example.forumapi.service.impl;

import com.example.forumapi.entity.Question;
import com.example.forumapi.repository.QuestionRepository;
import com.example.forumapi.repository.UserRepository;
import com.example.forumapi.service.JwtService;
import com.example.forumapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class QuestionImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public Question upload(Question question, String email) {
        Question que = new Question();
        que.setQuestion(question.getQuestion());
        que.setDate(question.getDate());
        que.setUser(userRepository.findByUserByEmail(email));
        questionRepository.save(que);
        return que ;
    }
}
