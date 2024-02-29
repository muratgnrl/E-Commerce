package com.example.helpservice.service.ımpl;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.exception.QuestionsNotCreateException;
import com.example.helpservice.exception.QuestionsNotDeleteException;
import com.example.helpservice.model.Questions;
import com.example.helpservice.repository.QuestionsRepository;
import com.example.helpservice.response.Meta;
import com.example.helpservice.response.QuestionsResponse;
import com.example.helpservice.service.QuestionsService;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsRepository questionsRepository;

    public QuestionsServiceImpl(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public QuestionsResponse deleteQuestions(long questionsId) throws QuestionsNotDeleteException {
        Questions questions = questionsRepository.findByQuestionsId(questionsId);
        if (questions !=null){
            questionsRepository.deleteByQuestionsId(questionsId);
            QuestionsResponse questionsResponse =new QuestionsResponse();
            questionsResponse.questionsDto=QuestionsDto.mapToDto(questions);
            questionsResponse.meta=new Meta(200,"Soru silindi");
            return questionsResponse;
        }else {
            throw new QuestionsNotDeleteException();
        }

    }

    @Override
    public QuestionsResponse addQuestions(QuestionsDto questionsDto) throws QuestionsNotCreateException {
        Questions questions =QuestionsDto.mapToEntity(questionsDto);
        questions=questionsRepository.save(questions);
        if (questions!=null){
            QuestionsResponse response = new QuestionsResponse();
            response.meta=new Meta(200,"Soru eklendi");
            response.questionsDto=QuestionsDto.mapToDto(questions);
            return response;
        }else {
            throw new QuestionsNotCreateException();
        }
    }
}
