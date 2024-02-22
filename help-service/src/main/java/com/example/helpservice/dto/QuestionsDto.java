package com.example.helpservice.dto;

import com.example.helpservice.entity.Answers;
import lombok.Data;


import java.util.List;
@Data

public class QuestionsDto {
    public int questionsId;
    public String questions;
    public List<Answers> answersList;
}
