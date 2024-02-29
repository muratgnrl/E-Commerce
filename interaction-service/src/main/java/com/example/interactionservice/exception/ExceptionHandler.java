package com.example.interactionservice.exception;

import com.example.interactionservice.response.CommentsResponse;
import com.example.interactionservice.response.FavouritesResponse;
import com.example.interactionservice.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addCommentsException(AddCommentsException addCommentsException, WebRequest webRequest){
        CommentsResponse commentsResponse =new CommentsResponse();
        commentsResponse.meta=new Meta(4004,"Yorum eklenemedi");
        ResponseEntity<Object> entity =new ResponseEntity<>(commentsResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> favouritesDeleteException(FavouritesDeleteException favouritesDeleteException, WebRequest webRequest){
        FavouritesResponse favouritesResponse =new FavouritesResponse();
        favouritesResponse.meta=new Meta(4004,"Favorilerden silinemedi");
        ResponseEntity<Object> entity =new ResponseEntity<>(favouritesResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addFavouritesException(AddFavouritesException addFavouritesException, WebRequest webRequest){
        FavouritesResponse favouritesResponse =new FavouritesResponse();
        favouritesResponse.meta=new Meta(4004,"Favorilere eklenemedi");
        ResponseEntity<Object> entity =new ResponseEntity<>(favouritesResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> favouritesNotFoundException(FavouritesNotFoundException favouritesNotFoundException, WebRequest webRequest){
        FavouritesResponse favouritesResponse =new FavouritesResponse();
        favouritesResponse.meta=new Meta(4004,"Bulunamadı");
        ResponseEntity<Object> entity =new ResponseEntity<>(favouritesResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> commentsNotDeletedException(CommentsNotDeletedException commentsNotDeletedException, WebRequest webRequest){
        CommentsResponse commentsResponse =new CommentsResponse();
        commentsResponse.meta=new Meta(4004,"Yorum silinemedi");
        ResponseEntity<Object> entity =new ResponseEntity<>(commentsResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
}
