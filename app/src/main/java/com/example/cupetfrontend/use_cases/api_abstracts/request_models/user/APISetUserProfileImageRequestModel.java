package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.SetUserProfileImageRequestModel;

public class APISetUserProfileImageRequestModel extends SetUserProfileImageRequestModel {
    public APISetUserProfileImageRequestModel(String token, String imgB64) {
        super(token, imgB64);
    }
}
