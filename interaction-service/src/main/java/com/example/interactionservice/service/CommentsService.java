package com.example.interactionservice.service;

import com.example.interactionservice.dto.CommentsDto;
import com.example.interactionservice.exception.AddCommentsException;
import com.example.interactionservice.exception.CommentsNotDeletedException;
import com.example.interactionservice.response.CommentsResponse;

public interface CommentsService {
    CommentsResponse addComments(CommentsDto commentsDto) throws AddCommentsException;

    CommentsResponse deleteComment(long commentId) throws CommentsNotDeletedException;
}
