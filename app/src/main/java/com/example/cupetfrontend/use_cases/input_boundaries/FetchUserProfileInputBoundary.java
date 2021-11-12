package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.FetchUserProfileRequestModel;

public interface FetchUserProfileInputBoundary {
    /**
     * Fetch a user's profile given request data
     * @param request The request data
     */
    void fetchUserProfile(FetchUserProfileRequestModel request);
}
