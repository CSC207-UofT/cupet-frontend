package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;

public interface GetPotentialMatchesInputBoundary {
    /**
     * Get a list of potential matches for a pet given request data
     *
     * @param request The request data
     */
    void getPotentialMatches(GetPotentialMatchesRequestModel request);
}
