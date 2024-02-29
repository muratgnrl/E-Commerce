package com.example.helpservice.response;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.model.Questions;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class QuestionsResponse extends BaseResponse implements Serializable {
    public QuestionsDto questionsDto;
}
