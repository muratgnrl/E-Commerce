package com.example.helpservice.repository;

import com.example.helpservice.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers,Long> {

    Answers findAnswersByAnswersId(long answersId);
}
