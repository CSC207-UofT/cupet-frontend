package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.PetCreatorRequestModel;

public interface PetCreatorInputBoundary {
    /**
     * Create a new pet given the request data
     * @param request The request data
     */
    void createPet(PetCreatorRequestModel request);
}
