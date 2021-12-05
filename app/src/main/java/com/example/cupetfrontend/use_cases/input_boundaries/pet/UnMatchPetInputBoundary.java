package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.UnMatchPetRequestModel;

public interface UnMatchPetInputBoundary {
    /**
     * Un-match a pet you've already matched with
     * @param request The request data
     */
    void unMatchPet(UnMatchPetRequestModel request);
}

