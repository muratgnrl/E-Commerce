package com.example.helpservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sorular")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionsId;
    private String questions;
    @OneToOne
    private Answers answers;

    public long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(long questionsId) {
        this.questionsId = questionsId;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public Questions() {
    }

    public Questions(long questionsId, String questions, Answers answers) {
        this.questionsId = questionsId;
        this.questions = questions;
        this.answers = answers;
    }
}
