package com.example.help.service;

import com.example.help.dto.QuestionsDto;
import com.example.help.exception.ExceptionQuestions;
import com.example.help.mapper.QuestionsMapper;
import com.example.help.model.Questions;
import com.example.help.repository.QuestionRepository;
import com.example.help.response.QuestionsResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    private final QuestionsMapper questionsMapper;
    private final QuestionRepository questionRepository;

    public QuestionsService(QuestionsMapper questionsMapper, QuestionRepository questionRepository) {
        this.questionsMapper = questionsMapper;
        this.questionRepository = questionRepository;
    }

    public QuestionsResponse addQuestion(QuestionsDto questionsDto) throws ExceptionQuestions {
        Questions questions=questionsMapper.toEntity(questionsDto);
        questions=questionRepository.save(questions);
        if (questions==null){
            throw new ExceptionQuestions();
        }
        return generateQuesitonsResult(questionsMapper.toResource(questions));
    }

    private QuestionsResponse generateQuesitonsResult(QuestionsDto resource) {
        QuestionsResponse questionsResponse=new QuestionsResponse();
        questionsResponse.questionsDto=resource;
        return questionsResponse;
    }


    public Questions findQuestion(int questionsId) {
        Questions questions=questionRepository.findQuestionsByQuestionsId(questionsId);
        if (questions==null){

            throw new EntityNotFoundException();
        }
        return questions;
    }
}
