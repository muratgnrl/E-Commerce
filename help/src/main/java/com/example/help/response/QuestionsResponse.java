package com.example.help.response;

import com.example.help.dto.QuestionsDto;

import java.io.Serializable;

public class QuestionsResponse extends BaseResponse implements Serializable {
    public QuestionsDto questionsDto;
}
