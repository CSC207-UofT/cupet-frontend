package com.example.cupetfrontend.ui.register;

import androidx.annotation.Nullable;

/**
 * Registration result : success (user details) or error message.
 */

public class RegisterResult {
    private final boolean isError;
    private final String errorMessage;

    public RegisterResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public RegisterResult(boolean isError) {
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
