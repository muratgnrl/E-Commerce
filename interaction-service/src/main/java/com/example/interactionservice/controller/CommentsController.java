package com.example.interactionservice.controller;

import com.example.interactionservice.dto.CommentsDto;
import com.example.interactionservice.exception.AddCommentsException;
import com.example.interactionservice.exception.CommentsNotDeletedException;
import com.example.interactionservice.response.CommentsResponse;
import com.example.interactionservice.service.ımpl.CommentsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private final CommentsServiceImpl commentsService;

    public CommentsController(CommentsServiceImpl commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/addComments")
    public ResponseEntity<CommentsResponse> addComments(@RequestBody CommentsDto commentsDto) throws AddCommentsException {
        CommentsResponse addComments = commentsService.addComments(commentsDto);
        return ResponseEntity.ok(addComments);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<CommentsResponse> deleteComment(@PathVariable(value = "commentId") long commentId) throws CommentsNotDeletedException {
        CommentsResponse deleteComment =  commentsService.deleteComment(commentId);
        return ResponseEntity.ok(deleteComment);
    }
}
