package com.example.helpservice.service.impl;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.entity.Questions;
import com.example.helpservice.exception.ExceptionNotFoundQuestions;
import com.example.helpservice.exception.ExceptionQuestion;
import com.example.helpservice.mapper.QuestionsMapper;
import com.example.helpservice.repository.QuestionsRepository;
import com.example.helpservice.response.Meta;
import com.example.helpservice.response.QuestionsResponse;
import com.example.helpservice.service.QuestionsService;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsRepository questionsRepository;
    private final QuestionsMapper questionsMapper;
    private final QuestionsResponse questionsResponse;
    public QuestionsServiceImpl(QuestionsRepository questionsRepository, QuestionsMapper questionsMapper, QuestionsResponse questionsResponse) {
        this.questionsRepository = questionsRepository;
        this.questionsMapper = questionsMapper;
        this.questionsResponse = questionsResponse;
    }

    @Override
    public QuestionsResponse addQuestions(QuestionsDto questionsDto) throws ExceptionQuestion {
        Questions questions=questionsMapper.toEntity(questionsDto);
        questions=questionsRepository.save(questions);
        if (questions!=null){
            questionsResponse.meta=new Meta(200,"Questions Added");
            questionsResponse.questionsDto=questionsMapper.toResource(questions);
            return questionsResponse;
        }else{
            throw new ExceptionQuestion();
        }
    }

    @Override
    public QuestionsResponse findQuestionsByDto(long questionsId) throws ExceptionNotFoundQuestions {
        Questions questions=findQuestions(questionsId);
        if (questions!=null){
            questionsResponse.meta=new Meta(200,"Questions found");
            questionsResponse.questionsDto=questionsMapper.toResource(questions);
            return questionsResponse;
        }else {
            throw new ExceptionNotFoundQuestions();

        }
    }

    public Questions findQuestions(long questionsId) {
        Questions questions=questionsRepository.findQuestionsByQuestionsId(questionsId);
        questionsMapper.toResource(questions);
        return questions;
    }
}
