package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.GetMatchesRequestModel;

public interface GetMatchesInputBoundary {
    /**
     * Get a list of successful matches for a pet given request data
     * @param request The request data
     */
    void getMatches(GetMatchesRequestModel request);
}
