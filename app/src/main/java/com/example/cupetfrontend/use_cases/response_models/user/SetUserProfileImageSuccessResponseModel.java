package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.response_models.ImageActionSuccessResponseModel;

public class SetUserProfileImageSuccessResponseModel extends ImageActionSuccessResponseModel {
    public SetUserProfileImageSuccessResponseModel(String imgUrl) {
        super(imgUrl);
    }
}
