package com.example.helpservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "yanıtlar")
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answersId;
    private String answers;

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

    public Answers() {
    }

    public Answers(long answersId, String answers) {
        this.answersId = answersId;
        this.answers = answers;
    }
}
