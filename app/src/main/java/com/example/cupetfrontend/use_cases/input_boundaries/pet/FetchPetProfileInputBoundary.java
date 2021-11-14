package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;

public interface FetchPetProfileInputBoundary {
    /**
     * Fetch a pet profile given request data
     * @param request The request data
     */
    void fetchPetProfile(FetchPetProfileRequestModel request);
}
