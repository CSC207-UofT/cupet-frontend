package com.example.cupetfrontend.unit_tests.use_cases.mocks;

/**
 * An exception that is thrown when an invalid dummy JSON is created
 * for the mock API gateway classes.
 */
public class InvalidDummyJSONException extends RuntimeException {
    public InvalidDummyJSONException(String message) {
        super(message);
    }
}
