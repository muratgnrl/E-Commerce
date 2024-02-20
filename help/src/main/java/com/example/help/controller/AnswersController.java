package com.example.help.controller;

import com.example.help.dto.AnswersDto;
import com.example.help.exception.ExceptionAnswer;
import com.example.help.response.AnswersResponse;
import com.example.help.service.AnswersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswersController {

    private final AnswersService answersService;

    public AnswersController(AnswersService answersService) {
        this.answersService = answersService;


    }

    @PostMapping("/addAnswers")
    public AnswersResponse addAnswers(@RequestBody AnswersDto answersDto) throws ExceptionAnswer {
        return answersService.addAnwers(answersDto);
    }
}
