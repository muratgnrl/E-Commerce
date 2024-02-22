package com.example.helpservice.entity;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Entity
public class Answers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answersId;
    private String answers;

    @ManyToOne
    @JoinColumn(name = "questionsId")
    private Questions questions;

    public Answers(long answersId, String answers, Questions questions) {
        this.answersId = answersId;
        this.answers = answers;
        this.questions = questions;
    }

    public Answers() {
    }

    public long getAnswersId() {
        return answersId;
    }

    public void setAnswersId(long answersId) {
        this.answersId = answersId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
