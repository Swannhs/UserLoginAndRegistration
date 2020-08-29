package com.swann.reactandspring.exception;

import lombok.Data;

@Data
public class EmailAlreadyExistResponse {
    private String message;

    public EmailAlreadyExistResponse(String message) {
        this.message = message;
    }
}
