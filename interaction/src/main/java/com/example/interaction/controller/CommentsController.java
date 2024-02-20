package com.example.interaction.controller;

import com.example.interaction.dto.CommentsDto;
import com.example.interaction.exception.AddCommentsException;
import com.example.interaction.response.CommentsResponse;
import com.example.interaction.service.CommentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/addComments")
    public CommentsResponse addComments(@RequestBody CommentsDto commentsDto) throws AddCommentsException {
        return commentsService.addComments(commentsDto);
    }
}
