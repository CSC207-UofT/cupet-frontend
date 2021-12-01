package com.example.cupetfrontend;

import org.json.JSONException;
import org.json.JSONObject;

public class EditPetProfileData {
    private String name;
    private int age;
    private String biography;
    private String breed;

    public EditPetProfileData(String name, int age, String biography){
        this.name = name;
        this.age = age;
        this.biography = biography;
        this.breed = breed;

    };

    public String getName(){
        return name;
    };

    public String getBreed(){
        return breed;
    };

    public int getAge(){
        return age;
    };

    public String getBiography(){
        return biography;
    }


    public boolean setName(String name){
        this.name = name;
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

    public String toJSON(){
      JSONObject jsonObject = new JSONObject();
      try {
          jsonObject.put("name", getName());
          jsonObject.put("age", getAge());
          jsonObject.put("biography", getBiography());
          return jsonObject.toString();
      } catch (JSONException e) {
          e.printStackTrace();
          return "";
      }
    };

}
