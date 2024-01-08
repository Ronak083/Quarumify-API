package com.example.forumapi.repository;

import com.example.forumapi.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Answer,Long> {
}
