package com.example.help.repository;

import com.example.help.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions,Integer> {

    Questions findQuestionsByQuestionsId(int questionsId);
}
