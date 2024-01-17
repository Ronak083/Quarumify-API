package com.example.forumapi.service.impl;

import com.example.forumapi.config.ResourceNotExisted;
import com.example.forumapi.entity.Answer;
import com.example.forumapi.entity.Question;
import com.example.forumapi.entity.Reply;
import com.example.forumapi.repository.AnswerRepository;
import com.example.forumapi.repository.QuestionRepository;
import com.example.forumapi.repository.ReplyRepository;
import com.example.forumapi.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final ReplyRepository replyRepository;
    List<Reply> replyList;

    @Override
    public List<Question> uploadAns(Answer answer, long id) {
        Question que = questionRepository.findById(id).orElseThrow(
                () -> new ResourceNotExisted("Question Not exist","Id", id));

        Answer ans = new Answer();
        ans.setAnswer(answer.getAnswer());
        ans.setDate(answer.getDate());
        ans.setUsername(answer.getUsername());
        ans.setQId(id);

        replyList = new ArrayList<>();
        ans.setReplies(replyList);

        que.getAnswer().add(ans);

        answerRepository.save(ans);
        return questionRepository.findAll();
    }

    @Override
    public List<Question> uploadRep(Reply rep, long id) {

        Answer parentAnswer = answerRepository.findById(id).orElseThrow(
                () -> new ResourceNotExisted("Answer Not exist","Id", id));

        Reply reply = new Reply();
        reply.setAId(id);
        reply.setDate(rep.getDate());
        reply.setReply(rep.getReply());
        reply.setUsername(rep.getUsername());
        parentAnswer.getReplies().add(reply);
        replyRepository.save(reply);
        return questionRepository.findAll();
    }


}