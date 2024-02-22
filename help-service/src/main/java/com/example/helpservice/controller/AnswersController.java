package com.example.helpservice.controller;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.exception.ExceptionAnswers;
import com.example.helpservice.exception.ExceptionDeleteAnswers;
import com.example.helpservice.response.AnswersResponse;
import com.example.helpservice.service.AnswersService;
import jakarta.ws.rs.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswersController {

    private final AnswersService answersService;

    public AnswersController(AnswersService answersService) {
        this.answersService = answersService;

    }

    @PostMapping("/addAnswers")
    public ResponseEntity<AnswersResponse> addAnswer(@RequestBody AnswersDto answersDto) throws ExceptionAnswers {
       AnswersResponse addAnswers=answersService.addAnswers(answersDto);
        return ResponseEntity.ok(addAnswers);

    }
    @DeleteMapping("/deleteAnswers")
    public ResponseEntity<AnswersResponse> deleteAnswers(@PathVariable (value = "answersId") long answersId) throws ExceptionDeleteAnswers {
        AnswersResponse deleteAnswers=answersService.deleteAnswers(answersId);
        return ResponseEntity.ok(deleteAnswers);
    }
}
