package com.example.cupetfrontend.ui.get_matches.recycler;

public class UnMatchResult {
    private boolean isError;
    private String errorMessage;

    public UnMatchResult(boolean isError) {
        this.isError = isError;
    }

    public UnMatchResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
