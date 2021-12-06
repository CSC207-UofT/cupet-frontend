package com.example.cupetfrontend;

public class EditUserProfileData {

    private String biography;
    private String facebook;
    private String instagram;
    private String phoneNumber;

    public String getBiography(){
        return biography;
    }
    public String getFacebook(){
        return this.facebook;
    }
    public String getInstagram(){
        return this.instagram;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public boolean setBiography(String biography){
        this.biography = biography;
        return true;
    }

    public boolean setPhoneNumber(String phoneNumber){
        this.biography = phoneNumber;
        return true;
    }

    public boolean setFacebook(String facebook){
        this.facebook = facebook;
        return true;
    }

    public boolean setInstagram(String instagram){
        this.instagram = instagram;
        return true;
    }

}
