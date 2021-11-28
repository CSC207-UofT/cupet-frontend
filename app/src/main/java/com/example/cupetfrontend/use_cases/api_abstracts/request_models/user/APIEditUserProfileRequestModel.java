package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.EditUserProfileRequestModel;

public class APIEditUserProfileRequestModel extends EditUserProfileRequestModel {
    public APIEditUserProfileRequestModel(String token, String newBiography, String newInstagram, String newFacebook, String newPhoneNumber) {
        super(token, newBiography, newInstagram, newFacebook, newPhoneNumber);
    }
}
