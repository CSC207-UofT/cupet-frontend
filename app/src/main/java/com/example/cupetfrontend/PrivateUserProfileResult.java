package com.example.cupetfrontend;

import java.util.ArrayList;
import java.util.List;

public class PrivateUserProfileResult {
    private boolean isError;
    private String errorMessage;
    private String firstName;
    private String lastName;
    private String biography;



    public PrivateUserProfileResult(boolean isError){
        this.isError = isError;
        errorMessage = "";
    }

    public PrivateUserProfileResult(String firstname, String lastname, String biography){
        this.firstName = firstname;
        this.lastName = lastname;
        this.biography = biography;
    }

    public boolean isError() {
        return isError;
    }



    public String getErrorMessage() {
        return errorMessage;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getBiography(){
        return this.biography;}
}
