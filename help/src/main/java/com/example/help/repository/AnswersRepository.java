package com.example.help.repository;

import com.example.help.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers,Integer> {
}
