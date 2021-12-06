package com.example.cupetfrontend.ui.user_profile;

import org.json.JSONException;
import org.json.JSONObject;

public class PrivateUserProfileData {

    private String biography;


    public String getBiography(){
        return biography;
    }


    public boolean setBiography(String biography){
        this.biography = biography;
        return true;
    };

}
