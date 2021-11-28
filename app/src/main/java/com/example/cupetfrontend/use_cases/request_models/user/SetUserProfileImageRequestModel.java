package com.example.cupetfrontend.use_cases.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.AddImageDataRequestModel;

public class SetUserProfileImageRequestModel extends AddImageDataRequestModel {
    public SetUserProfileImageRequestModel(String token, String imgB64) {
        super(token, imgB64);
    }
}

