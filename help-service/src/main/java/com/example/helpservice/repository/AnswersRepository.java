package com.example.helpservice.repository;

import com.example.helpservice.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers,Long> {
    Answers findByAnswersId(long answersId);

    void deleteByAnswersId(long answersId);
}
