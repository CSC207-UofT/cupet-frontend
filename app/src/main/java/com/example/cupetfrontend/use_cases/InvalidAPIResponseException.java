package com.example.cupetfrontend.use_cases;

public class InvalidAPIResponseException extends RuntimeException{
    public InvalidAPIResponseException(String message) {
        super(message);
    }
}
