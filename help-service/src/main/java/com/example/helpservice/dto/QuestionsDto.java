package com.example.helpservice.dto;

import com.example.helpservice.model.Questions;

import java.io.Serializable;

public class QuestionsDto implements Serializable  {
    public long questionsId;
    public String questions;
    public AnswersDto answersDto;


    public static Questions mapToEntity(QuestionsDto questionsDto) {
        Questions questions = new Questions();
        questions.setQuestionsId(questionsDto.questionsId);
        questions.setQuestions(questionsDto.questions);
        if (questionsDto.answersDto != null) {
            questions.setAnswers(AnswersDto.mapToEntity(questionsDto.answersDto));
        }
        return questions;
    }

    public static QuestionsDto mapToDto(Questions questions) {
        QuestionsDto dto = new QuestionsDto();
        dto.questionsId = questions.getQuestionsId();
        dto.questions = questions.getQuestions();
        if (questions.getAnswers() != null) {
            dto.answersDto = AnswersDto.mapToDto(questions.getAnswers());
        }
        return dto;
    }
}
