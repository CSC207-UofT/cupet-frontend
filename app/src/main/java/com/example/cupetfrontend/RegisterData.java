package com.example.cupetfrontend;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterData {
    String firstName;
    String lastName;
    String homeAddress;
    String password;
    String email;

    public RegisterData(String firstName, String lastName, String email, String password, String homeAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.homeAddress = homeAddress;

    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){ this.lastName = lastName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("firstName", getFirstName());
            jsonObject.put("lastName", getLastName());
            jsonObject.put("homeAddress", getHomeAddress());
            jsonObject.put("password", getPassword());
            jsonObject.put("email", getEmail());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

}
