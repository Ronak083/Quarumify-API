package com.example.forumapi.service.impl;

import com.example.forumapi.config.ResourceNotExisted;
import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.entity.Role;
import com.example.forumapi.entity.User;
import com.example.forumapi.repository.QuestionRepository;
import com.example.forumapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuestionImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    List<Answer> answersList;

    @Override
    public List<Question> upload(Question question) {
        Question que = new Question();
        que.setQuestion(question.getQuestion());
        que.setDate(question.getDate());
        que.setUsername(question.getUsername());
        answersList = new ArrayList<>();
        que.setAnswer(answersList);
        questionRepository.save(que);
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> deleteQuestion(long qid) {
        try {
            questionRepository.deleteById(qid);
        } catch (Exception e) {
            throw e;
        }
        return questionRepository.findAll();
    }

    @Override
    public List<Question> updateQuestion(Question que, long id) {
        Question q = questionRepository.findById(id).orElseThrow(
                () -> new ResourceNotExisted("Question Not exist",
                        "Id", id));
        q.setQuestion(que.getQuestion());
        questionRepository.save(q);

        return questionRepository.findAll();
    }

}