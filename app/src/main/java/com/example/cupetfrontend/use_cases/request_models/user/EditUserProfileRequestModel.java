package com.example.cupetfrontend.use_cases.request_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserProfile;

public class EditUserProfileRequestModel extends UserProfile {
    private final String token;

    public EditUserProfileRequestModel(String token, String biography, String instagram, String facebook, String phoneNumber) {
        super(biography, instagram, facebook, phoneNumber);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
