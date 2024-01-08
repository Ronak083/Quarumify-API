package com.example.forumapi.service;

import com.example.forumapi.entity.Question;

public interface QuestionService {
    Question upload(Question question, String name);
}
