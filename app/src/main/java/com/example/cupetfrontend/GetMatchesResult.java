package com.example.cupetfrontend;

import androidx.annotation.Nullable;

import java.util.List;

/**
 * Get Matches result : success (user details) or error message.
 */

public class GetMatchesResult {
    private final boolean isError;
    private final String errorMessage;
    @Nullable
    private List<String> matches;

    public GetMatchesResult(boolean isError) {
        this.isError = isError;
        this.errorMessage = "error getting Pet Matches";
        matches = null;
    }

    public GetMatchesResult(boolean isError, @Nullable List<String> matches) {
        this.isError = isError;
        errorMessage = "";
        this.matches = matches;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Nullable
    public List<String> getMatches() {
        return matches;
    }
}
