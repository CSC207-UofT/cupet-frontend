package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.GetPetsRequestModel;

public interface GetPetsInputBoundary {
    /**
     * Get a user's list of pets given request data
     * @param request The request data
     */
    void getPets(GetPetsRequestModel request);
}
