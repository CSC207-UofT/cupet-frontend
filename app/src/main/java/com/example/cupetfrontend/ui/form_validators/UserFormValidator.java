package com.example.cupetfrontend.ui.form_validators;

import android.util.Patterns;

/**
 * A class responsible for validating text entered
 * into user-related forms
 */
public class UserFormValidator {
    /**
     * Validate a user's first name
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateFirstName(String firstName) {
        if (firstName == null){
            return "The first name must be more than 2 characters long.";
        } else if (firstName.length() > 2){
            return null;
        }else{
            return "The first name must be more than 2 characters long.";
        }
    }

    /**
     * Validate a user's last name
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateLastName(String lastName) {
        if (lastName == null){
            return "The last name must be more than 2 characters long.";
        } else if (lastName.length() > 2){
            return null;
        }else{
            return "The last name must be more than 2 characters long.";
        }
    }

    /**
     * Validate a user's email
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateEmail(String email) {
        if (email == null) {
            return "Invalid email";
        }else if (email.contains("@") && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return null;
        } else {
            return "Invalid email";
        }
    }

    /**
     * Validate a user's password
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validatePassword(String password) {
        if (password == null){
            return "The password must be non-empty";
        } else if (password.matches(".*\\d.*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*")
        ){
            return null;
        }else{
            return "The password must include one digit, one uppercase character, and one lowercase character";
        }
    }

    /**
     * Validate a user's home address
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateHomeAddress(String homeAddress) {
        if (homeAddress == null){
            return "The home address must be non-empty";
        } else if (homeAddress.matches("^\\d* [0-9A-Za-z ]*$")){
            return null;
        }else{
            return "Invalid home address";
        }
    }

    /**
     * Validate a user's city
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateCity(String city) {
        if (city == null){
            return "The city must be non-empty";
        } else if (city.length() >= 3){
            return null;
        }else{
            return "City must be three characters or more";
        }
    }

    /**
     * Validate a user's biography
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateBiography(String biography) {
        return null;
    }

    /**
     * Validate a user's phone number
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.equals("")){
            return null;
        } else if (phoneNumber.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")){
            return null;
        }else{
            return "Invalid phone number";
        }
    }

    /**
     * Validate a user's facebook handle
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateFacebook(String facebook) {
        return null;
    }

    /**
     * Validate a user's instagram handle
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateInstagram(String instagram) {
        if (instagram == null || instagram.equals("")){
            return null;
        } else if (instagram.matches("^@.*$")){
            return null;
        }else{
            return "Instagram handles must start with @";
        }
    }
}
