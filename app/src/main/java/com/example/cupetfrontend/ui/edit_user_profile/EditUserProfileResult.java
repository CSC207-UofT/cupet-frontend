package com.example.cupetfrontend.ui.edit_user_profile;

public class EditUserProfileResult {
    private final boolean isError;
    private final String errorMessage;

    public EditUserProfileResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public EditUserProfileResult(boolean isError) {
        this.errorMessage = "";
        this.isError = isError;
    }


    public boolean isError() {
        return this.isError;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
