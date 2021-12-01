package com.example.cupetfrontend;

public class EditPetProfileResult {
    private boolean isError;
    private String errorMessage;

    public EditPetProfileResult(boolean isError, String errorMessage){
        this.isError = isError;
        this.errorMessage = errorMessage;

    }

    public void EditPetResult(boolean isError) {
        this.isError = isError;
        errorMessage = "";
    }

    public boolean isError() {return isError; }

    public String getErrorMessage() {return errorMessage; }
}
