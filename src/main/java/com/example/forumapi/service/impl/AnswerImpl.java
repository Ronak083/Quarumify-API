package com.example.forumapi.service.impl;

import com.example.forumapi.config.ResourceNotExisted;
import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.repository.AnswerRepository;
import com.example.forumapi.repository.QuestionRepository;
import com.example.forumapi.repository.UserRepository;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.JwtService;
import com.example.forumapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> upload(Answer answer, long id) {

        Question que = questionRepository.findById(id).orElseThrow(
                () -> new ResourceNotExisted("Question Not exist","Id", id));

        Answer ans = new Answer();
        ans.setAnswer(answer.getAnswer());
        ans.setDate(answer.getDate());
        ans.setUsername(answer.getUsername());
        que.getAnswer().add(ans);
        ans.setQId(id);
        answerRepository.save(ans);
        return questionRepository.findAll();
    }

}
