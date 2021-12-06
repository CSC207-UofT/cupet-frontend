package com.example.cupetfrontend.ui.edit_account;

import org.json.JSONException;
import org.json.JSONObject;

public class EditUserAccountData {
    private String email;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String password;


    public EditUserAccountData(){

    };

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFirstname(){
        return this.firstname;

    }

    public String getLastname(){
        return this.lastname;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public boolean setEmail(String email){
        this.email = email;
        return true;
    }

    public boolean setPassword(String password){
        this.password = password;
        return true;
    }

    public boolean setfirstName(String firstname){
        this.firstname = firstname;
        return true;
    }

    public boolean setlastName(String lastname){
        this.lastname = lastname;
        return true;
    }

    public boolean setAddress(String address){
        this.address = address;
        return true;
    }

    public boolean setCity(String city){
        this.city = city;
        return true;
    }

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", getEmail());
            jsonObject.put("firstname", getFirstname());
            jsonObject.put("lastname", getLastname());
            jsonObject.put("address", getAddress());
            jsonObject.put("city", getCity());
            jsonObject.put("password", getPassword());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    };

}

