package com.example.forumapi.service.impl;

import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.repository.AnswerRepository;
import com.example.forumapi.repository.QuestionRepository;
import com.example.forumapi.repository.UserRepository;
import com.example.forumapi.service.AnswerService;
import com.example.forumapi.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerImpl implements AnswerService {
    private final JwtService jwtService;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public Answer upload(Answer answer, String email) {
        Answer ans = new Answer();
        ans.setAnswer(answer.getAnswer());
        ans.setDate(answer.getDate());
        ans.setUser(userRepository.findByUserByEmail(email));

        return answerRepository.save(ans);
    }


}
