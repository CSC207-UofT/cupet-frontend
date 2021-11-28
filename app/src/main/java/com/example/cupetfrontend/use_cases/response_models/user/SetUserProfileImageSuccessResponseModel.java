package com.example.cupetfrontend.use_cases.response_models.user;

public class SetUserProfileImageSuccessResponseModel {
    private final String imgUrl;

    public SetUserProfileImageSuccessResponseModel(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
