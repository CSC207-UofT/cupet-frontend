package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserProfile;

public class EditUserProfileSuccessResponseModel extends UserProfile {
    public EditUserProfileSuccessResponseModel(String biography, String instagram, String facebook, String phoneNumber) {
        super(biography, instagram, facebook, phoneNumber);
    }
}
