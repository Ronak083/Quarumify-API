package com.example.forumapi.service.impl;

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
        Answer ans = new Answer();
        ans.setAnswer(answer.getAnswer());
        ans.setDate(answer.getDate());
        ans.setQId(id);        
        addAnswer(ans, id);
        answerRepository.save(ans);
        return questionRepository.findAll();
    }

    private void addAnswer(Answer ans, long id) {
        Optional<Question> q = questionRepository.findById(id);
        q.get().getAnswer().add(ans);
    }

}
