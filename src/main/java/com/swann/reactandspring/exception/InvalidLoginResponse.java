package com.swann.reactandspring.exception;

import lombok.Data;

@Data
public class InvalidLoginResponse {
    private String email;
    private String password;

    public InvalidLoginResponse() {
        this.email = "Invalid email";
        this.password = "Invalid password";
    }
}
