package com.example.helpservice.mapper;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.entity.Answers;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T12:45:01+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AnswersMapperImpl implements AnswersMapper {

    @Override
    public AnswersDto toResource(Answers e) {
        if ( e == null ) {
            return null;
        }

        AnswersDto answersDto = new AnswersDto();

        answersDto.answersId = e.getAnswersId();
        answersDto.answers = e.getAnswers();

        return answersDto;
    }

    @Override
    public Answers toEntity(AnswersDto r) {
        if ( r == null ) {
            return null;
        }

        Answers answers = new Answers();

        answers.setAnswersId( r.answersId );
        answers.setAnswers( r.answers );

        return answers;
    }

    @Override
    public List<AnswersDto> toResource(List<Answers> eList) {
        if ( eList == null ) {
            return null;
        }

        List<AnswersDto> list = new ArrayList<AnswersDto>( eList.size() );
        for ( Answers answers : eList ) {
            list.add( toResource( answers ) );
        }

        return list;
    }

    @Override
    public List<Answers> toEntity(List<AnswersDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Answers> list = new ArrayList<Answers>( rList.size() );
        for ( AnswersDto answersDto : rList ) {
            list.add( toEntity( answersDto ) );
        }

        return list;
    }
}
