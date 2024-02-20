package com.example.help.service;

import com.example.help.dto.AnswersDto;
import com.example.help.exception.ExceptionAnswer;
import com.example.help.mapper.AnswersMapper;
import com.example.help.model.Answers;
import com.example.help.repository.AnswersRepository;
import com.example.help.response.AnswersResponse;
import org.springframework.stereotype.Service;

@Service
public class AnswersService {

    private final AnswersRepository answersRepository;
    private final AnswersMapper answersMapper;

    public AnswersService(AnswersRepository answersRepository, AnswersMapper answersMapper) {
        this.answersRepository = answersRepository;
        this.answersMapper = answersMapper;
    }

    public AnswersResponse addAnwers(AnswersDto answersDto) throws ExceptionAnswer {
        Answers answers=answersMapper.toEntity(answersDto);
        answers=answersRepository.save(answers);
        if (answers==null){
            throw new ExceptionAnswer();
        }
        return generateAnswersResult(answersMapper.toResource(answers));
    }

    private AnswersResponse generateAnswersResult(AnswersDto resource) {
        AnswersResponse answersResponse=new AnswersResponse();
        answersResponse.answersDto=resource;
        return answersResponse;
    }


}
