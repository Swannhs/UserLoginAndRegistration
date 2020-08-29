package com.swann.reactandspring.exception;

import lombok.Data;

@Data
public class UsernameAlreadyExistsResponse {
    private String username;

    public UsernameAlreadyExistsResponse(String username) {
        this.username = username;
    }
}
