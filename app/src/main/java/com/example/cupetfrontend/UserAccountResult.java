package com.example.cupetfrontend;

public class UserAccountResult {
    private boolean isError;
    private String errorMessage;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String password;
    private String image_url;





    public UserAccountResult(boolean isError){
        this.isError = isError;
        errorMessage = "";
    }

    public UserAccountResult(String firstname, String lastname, String address, String city, String password, String image_url){
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.address = city;
        this.password = password;
        this.image_url = image_url;
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

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getPassword(){
        return this.password;
    }

    public String getImage_url(){ return this.image_url;}

}
