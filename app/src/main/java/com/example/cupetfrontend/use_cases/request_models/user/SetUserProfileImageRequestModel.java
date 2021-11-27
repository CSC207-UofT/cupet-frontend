package com.example.cupetfrontend.use_cases.request_models.user;

public class SetUserProfileImageRequestModel {
    private final String token;
    private final String imgB64;

    public SetUserProfileImageRequestModel(String token, String imgB64) {
        this.token = token;
        this.imgB64 = imgB64;
    }

    public String getToken() {
        return token;
    }

    public String getImgB64() {
        return imgB64;
    }
}

