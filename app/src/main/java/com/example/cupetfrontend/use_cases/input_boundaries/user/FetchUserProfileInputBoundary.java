package com.example.cupetfrontend.use_cases.input_boundaries.user;

import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileRequestModel;

public interface FetchUserProfileInputBoundary {
    /**
     * Fetch a user's profile given request data
     * @param request The request data
     */
    void fetchUserProfile(FetchUserProfileRequestModel request);
}
