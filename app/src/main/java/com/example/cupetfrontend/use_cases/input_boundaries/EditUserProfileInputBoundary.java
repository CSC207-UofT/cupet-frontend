package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.EditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.FetchPetProfileRequestModel;

public interface EditUserProfileInputBoundary {
    /**
     * Edit a user's profile given request data
     * @param request The request data
     */
    void editUserProfile(EditUserProfileRequestModel request);
}
