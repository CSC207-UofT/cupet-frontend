package com.example.cupetfrontend.use_cases.input_boundaries.user;

import com.example.cupetfrontend.use_cases.request_models.user.GetPetsRequestModel;

public interface GetPetsInputBoundary {
    /**
     * Get a user's list of pets given request data
     *
     * @param request The request data
     */
    void getPets(GetPetsRequestModel request);
}
