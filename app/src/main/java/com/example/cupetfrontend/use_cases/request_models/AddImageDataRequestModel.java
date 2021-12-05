package com.example.cupetfrontend.use_cases.request_models;

/**
 * This is a super class for request models which generally deal with uploading an image
 * associated with a pet or user.
 */
public class AddImageDataRequestModel {
    private final String token;
    private final String imgB64;

    public AddImageDataRequestModel(String token, String imgB64) {
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
