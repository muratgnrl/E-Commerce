package com.example.helpservice.controller;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.exception.AnswersNotCreateException;
import com.example.helpservice.exception.AnswersNotDeletedException;
import com.example.helpservice.exception.AnswersNotFindException;
import com.example.helpservice.response.AnswersResponse;
import com.example.helpservice.service.ımpl.AnswersServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswersController {
    private final AnswersServiceImpl answersService;
    public AnswersController(AnswersServiceImpl answersService) {
        this.answersService = answersService;
    }
    @PostMapping("/addAnswers")
    public ResponseEntity<AnswersResponse> addAnswers(@RequestBody AnswersDto answersDto) throws AnswersNotCreateException {
       AnswersResponse addAnswers = answersService.addAnswers(answersDto);
       return ResponseEntity.ok(addAnswers);}
    @GetMapping("/getAllAnswers")
    public ResponseEntity<List<AnswersDto>> getAllAnswers(){
        List<AnswersDto> getAllAnswers = answersService. getallAnswers();
        return ResponseEntity.ok(getAllAnswers);

    }
    @DeleteMapping("/deleteAnswers/{answersId}")
    public ResponseEntity<AnswersResponse> deleteAnswers(@PathVariable (value = "answersId") long answersId) throws AnswersNotDeletedException {
        AnswersResponse deleteAnswers = answersService.deleteAnswers(answersId);
        return ResponseEntity.ok(deleteAnswers);

    }
    @PutMapping("/updateAnswers/{answersId}")
    public ResponseEntity<AnswersDto> updateAnswers(@RequestBody AnswersDto dto, @PathVariable (value = "answersId") long answersId){
        AnswersDto updateAnswers = answersService.updateAnswers(dto,answersId);
        return ResponseEntity.ok(updateAnswers);

    }
    @GetMapping("/findAnswers")
    public ResponseEntity<AnswersResponse> getAnswers(@PathVariable (value = "answersId") long answersId) throws AnswersNotFindException {
        AnswersResponse getAnswers = answersService.getAnswers(answersId);
        return ResponseEntity.ok(getAnswers);

    }

}
