package com.example.forumapi.service;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.entity.Reply;

import java.util.List;


public interface AnswerService {

    List<Question> uploadAns(Answer answer, long id);
    List<Question> uploadRep(Reply reply, long id);
}
