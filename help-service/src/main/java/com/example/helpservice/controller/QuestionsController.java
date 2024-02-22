package com.example.helpservice.controller;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.exception.ExceptionNotFoundQuestions;
import com.example.helpservice.exception.ExceptionQuestion;
import com.example.helpservice.response.QuestionsResponse;
import com.example.helpservice.service.QuestionsService;
import com.example.helpservice.service.impl.QuestionsServiceImpl;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionsServiceImpl questionsService;

    public QuestionsController(QuestionsServiceImpl questionsService) {
        this.questionsService = questionsService;


    }

    @PostMapping("/addQuestions")
    public ResponseEntity<QuestionsResponse> addQuestions(@RequestBody QuestionsDto questionsDto) throws ExceptionQuestion {
        QuestionsResponse addQuestions=questionsService.addQuestions(questionsDto);
        return ResponseEntity.ok(addQuestions);
    }
    @GetMapping("/find/questions")
    public ResponseEntity<QuestionsResponse> findQuestionsByDto(@PathVariable(value = "questionsId") long questionsId) throws ExceptionNotFoundQuestions {
        QuestionsResponse findQuestions=questionsService.findQuestionsByDto(questionsId);
        return ResponseEntity.ok(findQuestions);
    }
}

