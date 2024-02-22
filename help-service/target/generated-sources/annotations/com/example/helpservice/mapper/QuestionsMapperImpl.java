package com.example.helpservice.mapper;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.entity.Questions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T12:45:02+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class QuestionsMapperImpl implements QuestionsMapper {

    @Override
    public QuestionsDto toResource(Questions e) {
        if ( e == null ) {
            return null;
        }

        QuestionsDto questionsDto = new QuestionsDto();

        questionsDto.questionsId = e.getQuestionsId();
        questionsDto.questions = e.getQuestions();

        return questionsDto;
    }

    @Override
    public Questions toEntity(QuestionsDto r) {
        if ( r == null ) {
            return null;
        }

        Questions questions = new Questions();

        questions.setQuestionsId( r.questionsId );
        questions.setQuestions( r.questions );

        return questions;
    }

    @Override
    public List<QuestionsDto> toResource(List<Questions> eList) {
        if ( eList == null ) {
            return null;
        }

        List<QuestionsDto> list = new ArrayList<QuestionsDto>( eList.size() );
        for ( Questions questions : eList ) {
            list.add( toResource( questions ) );
        }

        return list;
    }

    @Override
    public List<Questions> toEntity(List<QuestionsDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Questions> list = new ArrayList<Questions>( rList.size() );
        for ( QuestionsDto questionsDto : rList ) {
            list.add( toEntity( questionsDto ) );
        }

        return list;
    }
}
