package com.example.cupetfrontend.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    private final boolean isError;
    private final String errorMessage;
    private String token;

    public LoginResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public LoginResult(boolean isError) {
        this.isError = isError;
        errorMessage = "";
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}