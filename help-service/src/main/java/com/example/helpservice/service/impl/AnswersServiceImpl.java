package com.example.helpservice.service.impl;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.entity.Answers;
import com.example.helpservice.entity.Questions;
import com.example.helpservice.exception.ExceptionAnswers;
import com.example.helpservice.exception.ExceptionDeleteAnswers;
import com.example.helpservice.mapper.AnswersMapper;
import com.example.helpservice.repository.AnswersRepository;
import com.example.helpservice.response.AnswersResponse;
import com.example.helpservice.response.Meta;
import com.example.helpservice.service.AnswersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnswersServiceImpl implements AnswersService {

    private final AnswersRepository answersRepository;
    private final AnswersMapper answersMapper;
    private final AnswersResponse answersResponse;
    private final QuestionsServiceImpl questionsService;

    private final Logger logger= LoggerFactory.getLogger(AnswersServiceImpl.class);

    public AnswersServiceImpl(AnswersRepository answersRepository, AnswersMapper answersMapper, AnswersResponse answersResponse, QuestionsServiceImpl questionsService) {
        this.answersRepository = answersRepository;
        this.answersMapper = answersMapper;
        this.answersResponse = answersResponse;
        this.questionsService = questionsService;
    }

    @Override
    public AnswersResponse addAnswers(AnswersDto answersDto) throws ExceptionAnswers {
        Answers answers=answersMapper.toEntity(answersDto);
        Questions questions=questionsService.findQuestions(answersDto.questionsId);
        answers.setQuestions(questions);
        answers=answersRepository.save(answers);
        if (answers!=null){
            answersResponse.meta=new Meta(200,"Reply created");
            answersResponse.answersDto=answersMapper.toResource(answers);
            logger.info("Reply created");
            return answersResponse;
        }else {
            throw new ExceptionAnswers();
        }
    }

    @Override
    public AnswersResponse deleteAnswers(long answersId) throws ExceptionDeleteAnswers {
        Answers answers =answersRepository.findAnswersByAnswersId(answersId);
        if (answers!=null){
            answersRepository.deleteById(answersId);
            answersResponse.meta=new Meta(200,"Answers Deleted");
            answersResponse.answersDto=answersMapper.toResource(answers);
            logger.info("Reply deleted");
            return answersResponse;

        }else {
            throw new ExceptionDeleteAnswers();
        }
    }
}
