package com.example.helpservice.repository;

import com.example.helpservice.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    Questions findQuestionsByQuestionsId(long questionsId);
}
