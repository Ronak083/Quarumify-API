package com.example.forumapi.service;

import com.example.forumapi.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> upload(Question question);
    List<Question> getQuestions();

    List<Question> deleteQuestion(long qid);

    List<Question> updateQuestion(Question que, long id);
}
