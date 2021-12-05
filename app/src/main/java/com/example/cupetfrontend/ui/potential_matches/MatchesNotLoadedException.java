package com.example.cupetfrontend.ui.potential_matches;

/**
 * An exception thrown when a user tries to request a match,
 * but the matches have not yet been loaded yet.
 */
public class MatchesNotLoadedException extends RuntimeException {
    public MatchesNotLoadedException() {
    }
}
