package com.example.help.controller;

import com.example.help.dto.QuestionsDto;
import com.example.help.exception.ExceptionQuestions;
import com.example.help.model.Questions;
import com.example.help.response.QuestionsResponse;
import com.example.help.service.QuestionsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PostMapping("/addQuestion")
    public QuestionsResponse addQuestion(@RequestBody QuestionsDto questionsDto) throws ExceptionQuestions {
        return questionsService.addQuestion(questionsDto);
    }
    @GetMapping("/findQuestion/{questionsId}")
    public QuestionsResponse findQuestions(@PathVariable(value = "questionsId") int questionsId) throws EntityNotFoundException {
      QuestionsResponse questionsResponse=new QuestionsResponse();
        Questions questions=questionsService.findQuestion(questionsId);
        return questionsResponse;
    }
}
