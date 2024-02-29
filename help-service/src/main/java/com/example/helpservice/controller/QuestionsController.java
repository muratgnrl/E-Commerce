package com.example.helpservice.controller;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.exception.QuestionsNotCreateException;
import com.example.helpservice.exception.QuestionsNotDeleteException;
import com.example.helpservice.model.Questions;
import com.example.helpservice.response.QuestionsResponse;
import com.example.helpservice.service.ımpl.QuestionsServiceImpl;
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
    public ResponseEntity<QuestionsResponse> addQuestions (@RequestBody QuestionsDto questionsDto) throws QuestionsNotCreateException {
        QuestionsResponse addQuestions = questionsService.addQuestions(questionsDto);
        return ResponseEntity.ok(addQuestions);
    }
    @GetMapping("/deleteQuestions/{questionsId}")
    public ResponseEntity<QuestionsResponse> deleteQuestions(@PathVariable(value = "questionsId") long questionsId) throws QuestionsNotDeleteException {
        QuestionsResponse deleteQuestions = questionsService.deleteQuestions(questionsId);
        return ResponseEntity.ok(deleteQuestions);
    }
}
