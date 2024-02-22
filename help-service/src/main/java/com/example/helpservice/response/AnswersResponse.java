package com.example.helpservice.response;

import com.example.helpservice.dto.AnswersDto;
import org.springframework.stereotype.Component;


import java.io.Serializable;
@Component
public class AnswersResponse extends BaseResponse implements Serializable {
    public AnswersDto answersDto;
}
