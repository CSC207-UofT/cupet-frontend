package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.FetchPetProfileRequestModel;

public interface FetchPetProfileInputBoundary {
    /**
     * Fetch a pet profile given request data
     * @param request The request data
     */
    void fetchPetProfile(FetchPetProfileRequestModel request);
}
