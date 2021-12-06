package com.example.cupetfrontend.ui.user_profile;

import java.util.ArrayList;
import java.util.List;

public class PrivateUserProfileResult {
    private boolean isError;
    private String instagram;
    private String facebook;
    private String phoneNumber;
    private String image_url;
    private String errorMessage;
    private String biography;



    public PrivateUserProfileResult(boolean isError){
        this.isError = isError;
        errorMessage = "";
    }

    public PrivateUserProfileResult(String biography){

        this.biography = biography;
    }

    public PrivateUserProfileResult(boolean isError, String message) {
        this.isError = isError;
        this.errorMessage = message;
    }

    public boolean isError() {
        return isError;
    }



    public String getErrorMessage() {
        return errorMessage;
    }

    public String getBiography(){
        return this.biography;}

    public String getInstagram(){
        return this.instagram;}

    public String getFacebook(){
        return this.facebook;}

    public String getPhoneNumber(){
        return this.phoneNumber;}

    public String getImage_url(){
        return this.image_url;}
}
