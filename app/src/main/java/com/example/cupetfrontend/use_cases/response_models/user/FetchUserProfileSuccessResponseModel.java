package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserProfile;

public class FetchUserProfileSuccessResponseModel extends UserProfile {
    private final String firstName;
    private final String lastName;

    public FetchUserProfileSuccessResponseModel(String firstName, String lastName, String biography,
                                                String instagram, String facebook, String phoneNumber) {
        super(biography, instagram, facebook, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
