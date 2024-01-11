package com.example.forumapi.service;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;

import java.util.List;


public interface AnswerService {

    List<Question> upload(Answer answer, long id);

}
