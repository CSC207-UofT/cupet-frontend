package com.example.cupetfrontend.ui.potential_matches;

/**
 * An exception thrown when a user tries to request the next match,
 * but there are no more matches.
 */
public class OutOfMatchesException extends RuntimeException{
    public OutOfMatchesException() {
    }
}
