package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserProfile;

public class FetchUserProfileSuccessResponseModel extends UserProfile {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String profileImgUrl;

    public FetchUserProfileSuccessResponseModel(String firstName, String lastName, String email, String biography,
                                                String instagram, String facebook,
                                                String phoneNumber, String profileImgUrl) {
        super(biography, instagram, facebook, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profileImgUrl = profileImgUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public String getEmail() {
        return email;
    }
}
