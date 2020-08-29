package com.swann.reactandspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNameAlreadyExist extends RuntimeException{
    public UserNameAlreadyExist(String message){
        super(message);
    }
}
