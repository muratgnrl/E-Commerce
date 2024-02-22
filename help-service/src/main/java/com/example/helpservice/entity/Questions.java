package com.example.helpservice.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionsId;
    private String questions;


    @OneToMany(mappedBy = "questions")
    private List<Answers> answersList;

    public int getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(int questionsId) {
        this.questionsId = questionsId;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }

    public Questions(int questionsId, String questions, List<Answers> answersList) {
        this.questionsId = questionsId;
        this.questions = questions;
        this.answersList = answersList;
    }

    public Questions() {
    }
}
