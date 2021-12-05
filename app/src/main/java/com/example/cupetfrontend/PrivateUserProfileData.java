package com.example.cupetfrontend;

import org.json.JSONException;
import org.json.JSONObject;

public class PrivateUserProfileData {
    private String firstname;
    private String lastname;
    private int age;
    private String biography;


    public String getFirstname(){
        return firstname;
    };

    public String getLastname(){
        return lastname;
    };

    public int getAge(){
        return age;
    };

    public String getBiography(){
        return biography;
    }

    public boolean setfirstname(String firstname){
        this.firstname = firstname;
        return true;
    };

    public boolean setlastname(String firstname){
        this.lastname = lastname;
        return true;
    };

    public boolean setAge(int age){
        this.age = age;
        return true;
    };

    public boolean setBiography(String biography){
        this.biography = biography;
        return true;
    };

}
