package com.example.helpservice.repository;

import com.example.helpservice.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    Questions findByQuestionsId(long questionsId);

    void deleteByQuestionsId(long questionsId);
}
