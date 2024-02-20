package com.example.interaction.exception;

import com.example.interaction.response.CommentsResponse;
import com.example.interaction.response.FavouritesResponse;
import com.example.interaction.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

        @org.springframework.web.bind.annotation.ExceptionHandler
        public ResponseEntity<Object> addComments(AddCommentsException exception, WebRequest webRequest) {
            CommentsResponse commentsResponse=new CommentsResponse();
            Meta response = new Meta();
            response.errorCode = 6112;
            response.errorDecription = "Yorum ekleme Başarılı.";
            commentsResponse.meta=response;
            ResponseEntity<Object> entity = new ResponseEntity<>(commentsResponse, HttpStatus.NOT_FOUND);
            return entity;
        }

        @org.springframework.web.bind.annotation.ExceptionHandler
        public ResponseEntity<Object> favouritesException(AddFavouritesException exception, WebRequest webRequest) {
            FavouritesResponse favouritesResponse =new FavouritesResponse();
            Meta response = new Meta();
            response.errorCode = 6112;
            response.errorDecription = "Ürünü favorilere ekleme başarılı.";
            favouritesResponse.meta=response;
            ResponseEntity<Object> entity = new ResponseEntity<>(favouritesResponse, HttpStatus.NOT_FOUND);
            return entity;
        }


    }

