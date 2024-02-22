package com.example.helpservice.dto;





import lombok.Data;

import java.io.Serializable;
@Data
public class AnswersDto implements Serializable {
    public long answersId;
    public String answers;
    public long questionsId;
}
