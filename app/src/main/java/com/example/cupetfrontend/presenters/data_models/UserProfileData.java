package com.example.cupetfrontend.presenters.data_models;

import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;

public class UserProfileData extends FetchUserProfileSuccessResponseModel {
    public UserProfileData(String firstName, String lastName, String email, String biography,
                           String instagram, String facebook, String phoneNumber, String profileImgUrl) {
        super(firstName, lastName, email, biography, instagram, facebook, phoneNumber, profileImgUrl);
    }
}
