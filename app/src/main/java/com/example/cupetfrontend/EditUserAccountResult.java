package com.example.cupetfrontend;

import androidx.annotation.Nullable;

public class EditUserAccountResult {
    private final boolean isError;
    private final String errorMessage;


    public EditUserAccountResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public EditUserAccountResult(boolean isError) {
        this.isError = isError;
        errorMessage = "";
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
