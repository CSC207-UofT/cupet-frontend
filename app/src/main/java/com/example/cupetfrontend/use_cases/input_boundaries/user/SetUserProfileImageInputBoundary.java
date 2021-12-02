package com.example.cupetfrontend.use_cases.input_boundaries.user;

import com.example.cupetfrontend.use_cases.request_models.user.SetUserProfileImageRequestModel;

public interface SetUserProfileImageInputBoundary {
    /**
     * Set a user's profile image
     */
    void setUserProfileImage(SetUserProfileImageRequestModel request);
}
