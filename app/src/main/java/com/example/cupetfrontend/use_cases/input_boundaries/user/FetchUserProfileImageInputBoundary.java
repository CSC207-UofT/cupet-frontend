package com.example.cupetfrontend.use_cases.input_boundaries.user;

import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileImageRequestModel;

public interface FetchUserProfileImageInputBoundary {
    /**
     * Fetch a user's profile picture given request data
     *
     * @param request The request data
     */
    void fetchUserProfileImage(FetchUserProfileImageRequestModel request);
}
