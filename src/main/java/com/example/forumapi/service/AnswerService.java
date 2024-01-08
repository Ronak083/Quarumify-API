package com.example.forumapi.service;

import com.example.forumapi.entity.Answer;

public interface AnswerService {
    Answer upload(Answer answer, String email);
}
