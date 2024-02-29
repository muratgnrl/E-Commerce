package com.example.helpservice.service.ımpl;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.exception.AnswersNotCreateException;
import com.example.helpservice.exception.AnswersNotDeletedException;
import com.example.helpservice.exception.AnswersNotFindException;
import com.example.helpservice.model.Answers;
import com.example.helpservice.repository.AnswersRepository;
import com.example.helpservice.response.AnswersResponse;
import com.example.helpservice.response.Meta;
import com.example.helpservice.service.AnswersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService {
    private final AnswersRepository answersRepository;
    private static final Logger logger = LoggerFactory.getLogger(AnswersServiceImpl.class);

    public AnswersServiceImpl(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public AnswersResponse addAnswers(AnswersDto answersDto) throws AnswersNotCreateException {
        Answers answers = AnswersDto.mapToEntity(answersDto);
        answers = answersRepository.save(answers);
        if (answers != null) {
            AnswersResponse response = new AnswersResponse();
            response.answersDto = AnswersDto.mapToDto(answers);
            response.meta = new Meta(200, "Yanıt eklendi");
            return response;
        } else {
            throw new AnswersNotCreateException();
        }
    }

    @Override
    public List<AnswersDto> getallAnswers() {
        List<AnswersDto> answersDtos = new ArrayList<>();

        Iterable<Answers> answers = answersRepository.findAll();

        for (Answers answer : answers) {

            AnswersDto answersDto = AnswersDto.mapToDto(answer);
            answersDtos.add(answersDto);

        }
        return answersDtos;
    }

    @Override
    public AnswersResponse deleteAnswers(long answersId) throws AnswersNotDeletedException {
        Answers answers = answersRepository.findByAnswersId(answersId);
        if (answers != null) {
            answersRepository.deleteByAnswersId(answersId);
            AnswersResponse answersResponse = new AnswersResponse();
            answersResponse.meta = new Meta(200, "Yanıt silindi");
            answersResponse.answersDto = AnswersDto.mapToDto(answers);
            return answersResponse;
        } else {
            throw new AnswersNotDeletedException();
        }
    }

    @Override
    public AnswersDto updateAnswers(AnswersDto dto, long answersId) {
       Answers answers =AnswersDto.mapToEntity(dto);
        Answers saveAnswers =answersRepository.findByAnswersId(answersId);

        saveAnswers.setAnswersId(answers.getAnswersId());
        saveAnswers.setAnswers(answers.getAnswers());

        Answers updatedAnswers = answersRepository.save(saveAnswers);
        AnswersDto answersDto = AnswersDto.mapToDto(updatedAnswers);
        return answersDto;
    }

    @Override
    public AnswersResponse getAnswers(long answersId) throws AnswersNotFindException {
        Answers answers = findAnswers(answersId);
        if (answers != null) {
            AnswersResponse answersResponse =new AnswersResponse();
            answersResponse.meta=new Meta(200,"Yanıt Bulundu");
            answersResponse.answersDto=AnswersDto.mapToDto(answers);
            return answersResponse;
        }else {
            throw new AnswersNotFindException();
        }

    }

    private Answers findAnswers(long answersId) {
        Answers answers=answersRepository.findByAnswersId(answersId);
        AnswersDto.mapToDto(answers);
        return answers;
    }

}
